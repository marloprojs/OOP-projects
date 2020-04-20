import spotipy
import spotipy.util as util
from spotipy.oauth2 import SpotifyClientCredentials
import os
import sys
import time
import configparser
import logging

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
	playListSongList = dataInfo[1)
	sp.user_playlist_create(sp.current_user()['id'], plaListName)
	playListID = getPlaylistId(token, plaListName)
	#Cant add songs if there are no songs....
	if(len(playListSongList) > 0 ):
		sp.user_playlist_add_tracks(sp.current_user()['id'],playListID  , playListSongList)
	PlyListSongs = getSongIdList(token, getPlaylistId(token, dataInfo[0]))
	return [dataInfo[0], PlyListSongs]
