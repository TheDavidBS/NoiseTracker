/*
 * Copyright (C) 2010 Szymon Dembek
 * 
 * This source code is inspired from the source code of the official Android
 * Music Widget.
 * 
 * http://android.git.kernel.org/?p=platform/packages/apps/Music.git
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.android.music.player.service;

import android.graphics.Bitmap;

interface ICorePlayerService
{
	void InitIndex();
	int getBufferStatus();
	int getChannelCount();
	boolean isPlaying();
	void getMpListFilter();
	int getCurrentMediaAudioId();
	void prepare(boolean flag);
	void prepareWithLastPlayedFile(boolean flag);
	int getCurrent_ID();
	int getDuration();
	int getIndexOfPlayList();
	String getTrackName();
	int getLaunchMode();
	String getArtistName();
	String getMMediaFilePath();
	int getMaxVolume();
	void pause();
	void getNext(boolean flag);
	void getNextAlbumInfo();
	int getPlayListType();
	int getPosition();
	void getPrev();
	void getPrevAlbumInfo();
	void getRealEQdata(out int[] data);
	int getRepeat();
	int getSampleRate();
	boolean getShuffle();
	int getTotalMediaCount();
	void hideNotificationInfo();
	boolean isDuringCall();
	boolean isStop();
	String getCurrentMedia();
	void play();
	void a();
	void b();
	void c();
	void d();
	void e();
	void f();
	void g();
	void h();
	void i();
	void j();
	void k();
	void l();
	void m();
	boolean isThereLastPlayedFile();
	void n();
}