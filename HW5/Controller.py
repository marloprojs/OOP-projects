#!/usr/bin/env python3

import spotipy
import spotipy.util as util
from spotipy.oauth2 import SpotifyClientCredentials
import os
import sys
import time
import configparser
import logging


def getPlaylistInfo(token):
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
