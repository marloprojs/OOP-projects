#!/usr/bin/env python3

import spotipy
import spotipy.util as util
from spotipy.oauth2 import SpotifyClientCredentials
import os
import time
import configparser
import logging

DIR = os.path.dirname(os.path.abspath(__file__))
CFG_FILE_PATH = os.path.join(DIR, 'config.cfg')


class Recommender(object):

    def __init__(self):
        # open config files
        config = configparser.ConfigParser()
        config.read(CFG_FILE_PATH)
        log_cfg = config['logging']
        spotify_cfg = config['spotify']

        # start instance of spotify api
        auth = SpotifyClientCredentials(
            client_id=spotify_cfg['Client_id'],
            client_secret=spotify_cfg['Client_key'])
        token = auth.get_access_token()
        self.spotify = spotipy.Spotify(auth=token)

        # Set logging and formatter
        logging.basicConfig(filename=os.path.join(DIR, log_cfg['Path']),
                            filemode=log_cfg['Filemode'], format=log_cfg['Fmt'], datefmt=log_cfg['Date_fmt'], level=log_cfg['Level'])
        self.logger = logging.getLogger(__name__)

 