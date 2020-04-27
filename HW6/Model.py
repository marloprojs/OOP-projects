
import os
import sys
import time
import configparser
import logging
import requests


class Model_class:
	def getUserFilters(self, formDictionary):
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

	def getCallback(self, ip, port, code, spotObj):
		''' Function get a callback token
	        Input: IP, Port, and code
	        Output: Session token
	    '''
		redirect = "http://"+ip+":"+str(port)+"/callback"
		auth_token_url = f"{spotObj.API_BASE}/api/token"
		res = requests.post(auth_token_url, data={
			"grant_type":"authorization_code",
			"code":code,
			"redirect_uri":redirect,
			"client_id":spotObj.CLI_ID,
			"client_secret":spotObj.CLI_SEC
			})
		res_body = res.json()
		token = res_body.get("access_token")
		return token
		
	def getAuthUrl(self, ip, port, spotObj):
		''' Function to get authorization page url
			Input: ip and port
			Output: auth redirect url
		'''
		redirect = "http://"+ip+":"+str(port)+"/callback"
		auth_url = f'{spotObj.API_BASE}/authorize?client_id={spotObj.CLI_ID}&response_type=code&redirect_uri={redirect}&scope={spotObj.SCOPE}'
		return auth_url
