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

#make a secret key for flask
app = Flask(__name__)
app.secret_key = os.urandom(24)

#set globals
DIR = os.path.dirname(os.path.abspath(__file__))
CFG_FILE_PATH = os.path.join(DIR, 'config.cfg')
API_BASE = 'https://accounts.spotify.com'
REDIRECT_URI = "http://localhost:3000/callback"
SCOPE = 'playlist-modify-private,playlist-modify-public,playlist-read-collaborative,playlist-read-private'
CLI_ID = 'c5e2d53ffcd64af3839e40efbe4a7382'
CLI_SEC = 'bc0f50ed398246f9b5bdd1a06e189b9a'


@app.route("/")
def verify():
    ''' Function to login to a spotify account
        Input: None
        Output: Page redirect to login page
    '''
    auth_url = f'{API_BASE}/authorize?client_id={CLI_ID}&response_type=code&redirect_uri={REDIRECT_URI}&scope={SCOPE}'
    return redirect(auth_url)

@app.route("/home")
def home():
    ''' Function to display users owned playlist to home page
        Input: None
        Output: Page redirect to home page
    '''
    personal = Controller.getPlaylistInfo(session['toke'])
    return render_template("home.html", data=personal)


@app.route("/callback")
def callback():
    ''' Function to grab user login token 
        Input: None
        Output: page redirect to home page
    '''
    code = request.args.get('code')
    auth_token_url = f"{API_BASE}/api/token"
    res = requests.post(auth_token_url, data={
        "grant_type":"authorization_code",
        "code":code,
        "redirect_uri":REDIRECT_URI,
        "client_id":CLI_ID,
        "client_secret":CLI_SEC
        })
    res_body = res.json()

    session.clear()
    session["toke"] = res_body.get("access_token")

    return home()

    
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

    app.run(host="localhost", port=3000, debug=True)