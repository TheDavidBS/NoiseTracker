/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\dbenshab\\Documents\\JavaDevelopment\\workspace\\BindingMusicApp\\src\\com\\sec\\android\\app\\music\\ICorePlayerService.aidl
 */
package com.sec.android.app.music;
public interface ICorePlayerService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.sec.android.app.music.ICorePlayerService
{
private static final java.lang.String DESCRIPTOR = "com.sec.android.app.music.ICorePlayerService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.sec.android.app.music.ICorePlayerService interface,
 * generating a proxy if needed.
 */
public static com.sec.android.app.music.ICorePlayerService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.sec.android.app.music.ICorePlayerService))) {
return ((com.sec.android.app.music.ICorePlayerService)iin);
}
return new com.sec.android.app.music.ICorePlayerService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_InitIndex:
{
data.enforceInterface(DESCRIPTOR);
this.InitIndex();
reply.writeNoException();
return true;
}
case TRANSACTION_getBufferStatus:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getBufferStatus();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getChannelCount:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getChannelCount();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getCurrentFilePath:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getCurrentFilePath();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getMpListFilter:
{
data.enforceInterface(DESCRIPTOR);
this.getMpListFilter();
reply.writeNoException();
return true;
}
case TRANSACTION_getCurrentMediaAudioId:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCurrentMediaAudioId();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_prepare:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.prepare(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_prepareWithLastPlayedFile:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.prepareWithLastPlayedFile(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getCurrent_ID:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCurrent_ID();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getDuration:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getDuration();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getIndexOfPlayList:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getIndexOfPlayList();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isPlaying:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isPlaying();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getLaunchMode:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getLaunchMode();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getLyric:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getLyric();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getMMediaFilePath:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getMMediaFilePath();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getMaxVolume:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getMaxVolume();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getCurrentMedia:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getCurrentMedia();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getNext:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.getNext(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getNextAlbumInfo:
{
data.enforceInterface(DESCRIPTOR);
this.getNextAlbumInfo();
reply.writeNoException();
return true;
}
case TRANSACTION_getPlayListType:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getPlayListType();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getPosition:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getPosition();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getPrev:
{
data.enforceInterface(DESCRIPTOR);
this.getPrev();
reply.writeNoException();
return true;
}
case TRANSACTION_getPrevAlbumInfo:
{
data.enforceInterface(DESCRIPTOR);
this.getPrevAlbumInfo();
reply.writeNoException();
return true;
}
case TRANSACTION_getRealEQdata:
{
data.enforceInterface(DESCRIPTOR);
int[] _arg0;
int _arg0_length = data.readInt();
if ((_arg0_length<0)) {
_arg0 = null;
}
else {
_arg0 = new int[_arg0_length];
}
this.getRealEQdata(_arg0);
reply.writeNoException();
reply.writeIntArray(_arg0);
return true;
}
case TRANSACTION_getRepeat:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getRepeat();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getSampleRate:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getSampleRate();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getShuffle:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.getShuffle();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getTotalMediaCount:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getTotalMediaCount();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_hideNotificationInfo:
{
data.enforceInterface(DESCRIPTOR);
this.hideNotificationInfo();
reply.writeNoException();
return true;
}
case TRANSACTION_isDuringCall:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isDuringCall();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isStop:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isStop();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_pause:
{
data.enforceInterface(DESCRIPTOR);
this.pause();
reply.writeNoException();
return true;
}
case TRANSACTION_play:
{
data.enforceInterface(DESCRIPTOR);
this.play();
reply.writeNoException();
return true;
}
case TRANSACTION_a:
{
data.enforceInterface(DESCRIPTOR);
this.a();
reply.writeNoException();
return true;
}
case TRANSACTION_b:
{
data.enforceInterface(DESCRIPTOR);
this.b();
reply.writeNoException();
return true;
}
case TRANSACTION_c:
{
data.enforceInterface(DESCRIPTOR);
this.c();
reply.writeNoException();
return true;
}
case TRANSACTION_d:
{
data.enforceInterface(DESCRIPTOR);
this.d();
reply.writeNoException();
return true;
}
case TRANSACTION_e:
{
data.enforceInterface(DESCRIPTOR);
this.e();
reply.writeNoException();
return true;
}
case TRANSACTION_f:
{
data.enforceInterface(DESCRIPTOR);
this.f();
reply.writeNoException();
return true;
}
case TRANSACTION_g:
{
data.enforceInterface(DESCRIPTOR);
this.g();
reply.writeNoException();
return true;
}
case TRANSACTION_h:
{
data.enforceInterface(DESCRIPTOR);
this.h();
reply.writeNoException();
return true;
}
case TRANSACTION_i:
{
data.enforceInterface(DESCRIPTOR);
this.i();
reply.writeNoException();
return true;
}
case TRANSACTION_j:
{
data.enforceInterface(DESCRIPTOR);
this.j();
reply.writeNoException();
return true;
}
case TRANSACTION_k:
{
data.enforceInterface(DESCRIPTOR);
this.k();
reply.writeNoException();
return true;
}
case TRANSACTION_l:
{
data.enforceInterface(DESCRIPTOR);
this.l();
reply.writeNoException();
return true;
}
case TRANSACTION_m:
{
data.enforceInterface(DESCRIPTOR);
this.m();
reply.writeNoException();
return true;
}
case TRANSACTION_isThereLastPlayedFile:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isThereLastPlayedFile();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_n:
{
data.enforceInterface(DESCRIPTOR);
this.n();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.sec.android.app.music.ICorePlayerService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void InitIndex() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_InitIndex, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getBufferStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getBufferStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getChannelCount() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getChannelCount, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getCurrentFilePath() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentFilePath, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void getMpListFilter() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMpListFilter, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getCurrentMediaAudioId() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentMediaAudioId, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void prepare(boolean flag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((flag)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_prepare, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void prepareWithLastPlayedFile(boolean flag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((flag)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_prepareWithLastPlayedFile, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getCurrent_ID() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrent_ID, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getDuration() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDuration, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getIndexOfPlayList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIndexOfPlayList, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isPlaying() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isPlaying, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getLaunchMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLaunchMode, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getLyric() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLyric, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getMMediaFilePath() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMMediaFilePath, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getMaxVolume() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMaxVolume, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getCurrentMedia() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentMedia, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void getNext(boolean flag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((flag)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_getNext, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void getNextAlbumInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNextAlbumInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getPlayListType() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPlayListType, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getPosition() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPosition, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void getPrev() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrev, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void getPrevAlbumInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrevAlbumInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void getRealEQdata(int[] data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((data==null)) {
_data.writeInt(-1);
}
else {
_data.writeInt(data.length);
}
mRemote.transact(Stub.TRANSACTION_getRealEQdata, _data, _reply, 0);
_reply.readException();
_reply.readIntArray(data);
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getRepeat() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRepeat, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getSampleRate() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSampleRate, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean getShuffle() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getShuffle, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getTotalMediaCount() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTotalMediaCount, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void hideNotificationInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_hideNotificationInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean isDuringCall() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isDuringCall, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isStop() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isStop, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void pause() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_pause, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void play() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_play, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void a() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_a, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void b() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_b, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void c() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_c, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void d() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_d, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void e() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_e, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void f() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_f, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void g() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_g, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void h() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_h, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void i() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_i, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void j() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_j, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void k() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_k, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void l() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_l, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void m() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_m, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean isThereLastPlayedFile() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isThereLastPlayedFile, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void n() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_n, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_InitIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getBufferStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getChannelCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getCurrentFilePath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getMpListFilter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getCurrentMediaAudioId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_prepare = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_prepareWithLastPlayedFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_getCurrent_ID = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_getDuration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_getIndexOfPlayList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_isPlaying = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_getLaunchMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_getLyric = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_getMMediaFilePath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_getMaxVolume = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_getCurrentMedia = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_getNext = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_getNextAlbumInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_getPlayListType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_getPosition = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_getPrev = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_getPrevAlbumInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_getRealEQdata = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_getRepeat = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_getSampleRate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_getShuffle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
static final int TRANSACTION_getTotalMediaCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
static final int TRANSACTION_hideNotificationInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
static final int TRANSACTION_isDuringCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
static final int TRANSACTION_isStop = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
static final int TRANSACTION_pause = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
static final int TRANSACTION_play = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
static final int TRANSACTION_a = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
static final int TRANSACTION_b = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
static final int TRANSACTION_c = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
static final int TRANSACTION_d = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
static final int TRANSACTION_e = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
static final int TRANSACTION_f = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
static final int TRANSACTION_g = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
static final int TRANSACTION_h = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
static final int TRANSACTION_i = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
static final int TRANSACTION_j = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
static final int TRANSACTION_k = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
static final int TRANSACTION_l = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
static final int TRANSACTION_m = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
static final int TRANSACTION_isThereLastPlayedFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
static final int TRANSACTION_n = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
}
public void InitIndex() throws android.os.RemoteException;
public int getBufferStatus() throws android.os.RemoteException;
public int getChannelCount() throws android.os.RemoteException;
public java.lang.String getCurrentFilePath() throws android.os.RemoteException;
public void getMpListFilter() throws android.os.RemoteException;
public int getCurrentMediaAudioId() throws android.os.RemoteException;
public void prepare(boolean flag) throws android.os.RemoteException;
public void prepareWithLastPlayedFile(boolean flag) throws android.os.RemoteException;
public int getCurrent_ID() throws android.os.RemoteException;
public int getDuration() throws android.os.RemoteException;
public int getIndexOfPlayList() throws android.os.RemoteException;
public boolean isPlaying() throws android.os.RemoteException;
public int getLaunchMode() throws android.os.RemoteException;
public java.lang.String getLyric() throws android.os.RemoteException;
public java.lang.String getMMediaFilePath() throws android.os.RemoteException;
public int getMaxVolume() throws android.os.RemoteException;
public java.lang.String getCurrentMedia() throws android.os.RemoteException;
public void getNext(boolean flag) throws android.os.RemoteException;
public void getNextAlbumInfo() throws android.os.RemoteException;
public int getPlayListType() throws android.os.RemoteException;
public int getPosition() throws android.os.RemoteException;
public void getPrev() throws android.os.RemoteException;
public void getPrevAlbumInfo() throws android.os.RemoteException;
public void getRealEQdata(int[] data) throws android.os.RemoteException;
public int getRepeat() throws android.os.RemoteException;
public int getSampleRate() throws android.os.RemoteException;
public boolean getShuffle() throws android.os.RemoteException;
public int getTotalMediaCount() throws android.os.RemoteException;
public void hideNotificationInfo() throws android.os.RemoteException;
public boolean isDuringCall() throws android.os.RemoteException;
public boolean isStop() throws android.os.RemoteException;
public void pause() throws android.os.RemoteException;
public void play() throws android.os.RemoteException;
public void a() throws android.os.RemoteException;
public void b() throws android.os.RemoteException;
public void c() throws android.os.RemoteException;
public void d() throws android.os.RemoteException;
public void e() throws android.os.RemoteException;
public void f() throws android.os.RemoteException;
public void g() throws android.os.RemoteException;
public void h() throws android.os.RemoteException;
public void i() throws android.os.RemoteException;
public void j() throws android.os.RemoteException;
public void k() throws android.os.RemoteException;
public void l() throws android.os.RemoteException;
public void m() throws android.os.RemoteException;
public boolean isThereLastPlayedFile() throws android.os.RemoteException;
public void n() throws android.os.RemoteException;
}
