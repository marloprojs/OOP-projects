#!/usr/bin/env python3

import spotipy
import spotipy.util as util
from spotipy.oauth2 import SpotifyClientCredentials
import os
import sys
import time
import configparser
import requests
import logging

class spot:
	API_BASE = 'https://accounts.spotify.com'
	REDIRECT_URI = "http://localhost:3000/callback"
	SCOPE = 'playlist-modify-private,playlist-modify-public,playlist-read-collaborative,playlist-read-private'
	CLI_ID = 'c5e2d53ffcd64af3839e40efbe4a7382'
	CLI_SEC = 'bc0f50ed398246f9b5bdd1a06e189b9a'
class Control_class:
	def getPlaylistInfo(self,token):
		''' Function to display users own playlist
			Input: session token
			Output: list of [[playlist name, playlist image]]
		'''
		personal = []
		sp = spotipy.client.Spotify(auth=token)
		playlists = sp.current_user_playlists()
		for playlist in playlists['items']:
			# only display playlists they own (and 1st image of that playlist)
			if playlist['owner']['id'] == sp.current_user()['id']:
				if len(playlist['images']) == 0:
					personal.append([playlist['name'], "./static/default.png"])
				else:
					personal.append([playlist['name'], playlist['images'][0] ['url']])
		return personal


	def getAuthUrl(self, ip, port, spotObj):
		''' Function to get authorization page url
			Input: ip and port
			Output: auth redirect url
		'''
		redirect = "http://"+ip+":"+str(port)+"/callback"
		auth_url = f'{spotObj.API_BASE}/authorize?client_id={spotObj.CLI_ID}&response_type=code&redirect_uri={redirect}&scope={spotObj.SCOPE}'
		return auth_url

	## api dont like???? ################################################################################
	#need to strip whitespace from front and. Playlist may have them in spotify app but api does not like them
	def getPlaylistId(self, token, playlistName):
		''' Function to get a playlist id
			Input: token and playlist name
			Output: playlist id
		'''
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
	def getPlaylistSongs(self, token, playlistId):
		''' Function to display users songs in spesific playlist
			Input: session token and playlist id
			Output: list of [[track, artist]]
		'''
		personal = []
		sp = spotipy.client.Spotify(auth=token)
		tracks = sp.user_playlist_tracks(user=sp.current_user()['id'], playlist_id=playlistId)
		for track in tracks['items']:
			artists = []
			for art in track['track']['artists']:
				artists.append([art['name']])
			personal.append([track['track'], track['track']])
		return personal


	def getSongIdList(self, token, playlistId):
		songIds = []
		sp = spotipy.client.Spotify(auth=token)
		tracks = sp.user_playlist_tracks(user=sp.current_user()['id'], playlist_id=playlistId)
		for track in tracks['items']:
			songIds.append(track['track']['id'])
		return songIds

	def filterSongs(self, token, songIDList, filterCriteriaDict, newPlayListName):
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


	def createPlayList(self, token, dataInfo):
		sp = spotipy.client.Spotify(auth=token)
		#creatinng new PlayList
		plaListName = dataInfo[0]
		print("New playlist name: ", plaListName)
		playListSongList = dataInfo[1]
		sp.user_playlist_create(sp.current_user()['id'], plaListName)
		playListID = self.getPlaylistId(token, plaListName)
		#Cant add songs if there are no songs....
		if(len(playListSongList) > 0 ):
			sp.user_playlist_add_tracks(sp.current_user()['id'],playListID  , playListSongList)
		PlyListSongs = self.getSongIdList(token, self.getPlaylistId(token, dataInfo[0]))
		return [dataInfo[0], PlyListSongs]

	def getSinglePlaylistLinfo(self,token,playList):
		#personal = []
		sp = spotipy.client.Spotify(auth=token)
		playlists = sp.current_user_playlists()
		playlistName = playList.strip()
		for playlist in playlists['items']:
			# only display playlists they own (and 1st image of that playlist)
			if playlist['name'].strip() == playlistName:
				#personal.append(playlist)
				return playlist
		return
