from flask import Flask, render_template, redirect, request, session, make_response,session,redirect
import spotipy
import spotipy.util as util
from spotipy.oauth2 import SpotifyClientCredentials
import os
import sys
import time
import configparser
import logging
import requests
import Controller
import Model

<<<<<<< HEAD
#make a secret key for flask
app = Flask(__name__)
app.secret_key = os.urandom(24)

#set globals
DIR = os.path.dirname(os.path.abspath(__file__))
CFG_FILE_PATH = os.path.join(DIR, 'config.cfg')
IP = "localhost"
PORT = 3000


@app.route("/")
def verify():
	''' Function to login to a spotify account
		Input: None
		Output: Page redirect to login page
		'''
	auth_url = Controller.getAuthUrl(IP, PORT)
	return redirect(auth_url)

@app.route("/home")
def home():
	''' Function to display users owned playlist to home page
		Input: None
		Output: Page redirect to home page
	'''
	personal = Controller.getPlaylistInfo(session['toke'])

	return render_template("home.html", data=personal)


@app.route("/recommend")
def recommend():
	''' Function to render the music page
        Input:  None
        Output: render_template
    '''
	personal = Controller.getPlaylistInfo(session['toke'])
	return render_template("music.html", data=personal)



@app.route("/<playlist>")
def songs(playlist):
	''' Function to display users songs in spesific playlist
		Input: playlist id
		Output: Page redirect to tracks page
	'''
	playlistId = Controller.getPlaylistId(session['toke'], playlist)
	if(playlistId):
		personal = Controller.getPlaylistSongs(session['toke'], playlistId)
		return render_template("tracks.html", data=personal)

	else:
		return render_template("tracks.html")

@app.route("/filter<playlist>")
def filterPage(playlist):
	return render_template("filterPage.html" ,data = playlist)


#Grabbing form data
@app.route("/newPlayList<playlist>", methods = ['POST', 'GET'])
def newPlayList(playlist):
	''' Function to grab filters from user and make new playlist
        Input: playlist name
        Output: renter_template
    '''
	formDictionary = request.form.to_dict()
	userSelectFeatureValueDictionary = Model.getUserFilters(formDictionary)

	playlistId = Controller.getPlaylistId(session['toke'], playlist)
	songIdList = Controller.getSongIdList(session['toke'], playlistId)
	newSongList = Controller.filterSongs(session['toke'],songIdList,userSelectFeatureValueDictionary,formDictionary['name'])

	#[NameOfNewPlayList, [List of filtered Song List]]
	newPlayListInfo = [formDictionary['name'], newSongList ]
	#Creates playlist with given name and list of songs. returns [playlistname, playlistIdsChosen]
	newPlayListCreatore = Controller.createPlayList(session['toke'], newPlayListInfo)
	#tracks.html and getPlayListSongs work together to get author and song name in table form
	personal = Controller.getPlaylistSongs(session['toke'],Controller.getPlaylistId(session['toke'], newPlayListCreatore[0]))
	return render_template("tracks.html", data=personal )


@app.route("/callback")
def callback():
    ''' Function to grab user login token
        Input: None
        Output: page redirect to home page
    '''
    code = request.args.get('code')
    session.clear()
    session["toke"] = Controller.getCallback(IP, PORT, code)

    return home()

@app.route('/contact')
def contact():
    ''' Function to render the contact html page 
        Input:  None
        Output: render_template
    '''
    return render_template('contact.html')


@app.route('/about')
def about():
    ''' Function to render the about html page
        Input:  None
        Output: render_template
    '''
    return render_template('about.html')



@app.errorhandler(404)
def page_not_found(error):
    ''' Function to handle a path not found ie. anything like localhost:port/fakePath
        Input: None
        Output: None
    '''
    return render_template('page_not_found.html'), 404



if __name__ == "__main__":
    # open config files
    config = configparser.ConfigParser()
    config.read(CFG_FILE_PATH)
    log_cfg = config['logging']
    spotify_cfg = config['spotify']
    username = ''

    # Set logging and formatter
    logging.basicConfig(filename=os.path.join(DIR, log_cfg['Path']),
                        filemode=log_cfg['Filemode'], format=log_cfg['Fmt'], datefmt=log_cfg['Date_fmt'], level=log_cfg['Level'])
    slogger = logging.getLogger(__name__)


    #os.environ['SPOTIPY_CLIENT_ID']=spotify_cfg['Client_id']
    #os.environ['SPOTIPY_CLIENT_SECRET']=spotify_cfg['Client_key']

    # play with spotify
    print("Done")

    app.run(host=IP, port=PORT, debug=True)
=======
#need to strip whitespace from front and. Playlist may have them in spotify app but api does not like them
def getPlaylistId(token, playlistName):
	personal = None
	sp = spotipy.client.Spotify(auth=token)
	playlists = sp.current_user_playlists()
	playlistName = playlistName.strip()
	for playlist in playlists['items']:
		# only display playlists they own (and 1st image of that playlist)
		if (playlist['owner']['id'] == sp.current_user()['id']) and (playlist['name'].strip() == playlistName):
			personal = playlist['id']
	return personal


#need to go back and fix this ... my bad
def getPlaylistSongs(token, playlistId):
	personal = []
	sp = spotipy.client.Spotify(auth=token)
	tracks = sp.user_playlist_tracks(user=sp.current_user()['id'], playlist_id=playlistId)
	for track in tracks['items']:
		artists = []
		for art in track['track']['artists']:
			artists.append([art['name']])
		personal.append([track['track'], track['track']])
	return personal

def getSongIdList(token, playlistId):
	songIds = []
	sp = spotipy.client.Spotify(auth=token)
	tracks = sp.user_playlist_tracks(user=sp.current_user()['id'], playlist_id=playlistId)
	for track in tracks['items']:
		songIds.append(track['track']['id'])
	return songIds

def filterSongs(token, songIDList, filterCriteriaDict, newPlayListName):
	#dictionary values are passed as a string. Need to get the value as float
	for key in filterCriteriaDict:
		valuesStringtoList = filterCriteriaDict[key].split(" to ")
		filterCriteriaDict[key] = [float(valuesStringtoList[0]), float(valuesStringtoList[1])]
	updatedSongList = []
	sp = spotipy.client.Spotify(auth=token)
	#we can pass in a list of songIDs which we have already
	songAudioFeatures = sp.audio_features(songIDList)
	#print (songAudioFeatures)
	for songInfo in songAudioFeatures: #getting one song at a time
		addNewSong = True
		for featureKey in filterCriteriaDict: #getting each Feature user selected
			#Song does not meet criteria. features in song are lower case. whoops lol
			if(songInfo[featureKey.lower()] <  filterCriteriaDict[featureKey][0]) or (songInfo[featureKey.lower()] >  filterCriteriaDict[featureKey][1]):
				addNewSong = False
		if addNewSong == True:
			updatedSongList.append(songInfo['id'])
	#print(updatedSongList)
	return updatedSongList




def createPlayList(token, dataInfo):
	sp = spotipy.client.Spotify(auth=token)
	#creatinng new PlayList
	plaListName = dataInfo[0]
	playListSongList = dataInfo[1]
	sp.user_playlist_create(sp.current_user()['id'], plaListName)
	playListID = getPlaylistId(token, plaListName)
	#Cant add songs if there are no songs....
	if(len(playListSongList) > 0 ):
		sp.user_playlist_add_tracks(sp.current_user()['id'],playListID  , playListSongList)
	PlyListSongs = getSongIdList(token, getPlaylistId(token, dataInfo[0]))
	return [dataInfo[0], PlyListSongs]
>>>>>>> origin/master
