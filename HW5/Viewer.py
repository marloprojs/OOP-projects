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
	index = 1
	for track in tracks['items']:
		songIds.append(track['track']['id'])
	return songIds
