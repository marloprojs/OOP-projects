
import os
import sys
import time
import configparser
import logging



def getUserFilters(formDictionary):
	''' Function to display users own playlist
		Input: session token
		Output: list of [[playlist name, playlist image]]
	'''
	listOfFeatures = ["Acousticness", "Danceability", "Energy", "Instrumentalness", "Liveness", "Loudness", "speechiness", "Valence", "Tempo"]
	userSelectFeatureValueDictionary = {}
	for key in formDictionary:
		if key in listOfFeatures:
			updateFeature = key + "Text" #need to add Text to get the value user put in the text box
			userSelectFeatureValueDictionary[key] = formDictionary[updateFeature]
	return userSelectFeatureValueDictionary
