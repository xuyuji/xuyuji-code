功能：
通过JNI调用调用MSSpeachSDK的C++代码来实现tts。

1.安装SpeechSDK51.exe、SpeechSDK51LangPack.exe.
2.新建SpeechSdkTest.java类.
3.进入工程bin目录执行命令javah test.msspeechsdk51.SpeechSdkTest生成方法头文件test_msspeechsdk51_SpeechSdkTest.h
(ps:javah默认参数-jni,即javah等价于javah -jni)
4.用VS新建Win32项目,dll+空项目.
将2步生成的头文件拷贝进该工程目录.
将java根目录/include/jni.h、java根目录/include/win32/jawt_md.h、java根目录/include/win32/jni_md.h拷贝进该工程目录.
导入这4个头文件.将test_msspeechsdk51_SpeechSdkTest.h中的#include <jni.h>改为#include "jni.h".
新建test_msspeechsdk51_SpeechSdkTest.cpp,写入如下代码：
#include <windows.h>
#include <Servprov.h>
#include <sapi.h>
#pragma comment(lib,"ole32.lib") //CoInitialize CoCreateInstance需要调用ole32.dll
#pragma comment(lib,"sapi.lib") //sapi.lib在SDK的lib目录,必需正确配置
#include "test_msspeechsdk51_SpeechSdkTest.h"

JNIEXPORT jint JNICALL Java_test_msspeechsdk51_SpeechSdkTest_speak
  (JNIEnv *env, jobject obj, jstring s){
	const jchar* _s = env->GetStringChars(s, 0);
	ISpVoice * pVoice = NULL; //COM初始化：
	if (FAILED(::CoInitialize(NULL)))
		return FALSE; //获取ISpVoice接口：
	HRESULT hr = CoCreateInstance(CLSID_SpVoice, NULL, CLSCTX_ALL, IID_ISpVoice, (void **)&pVoice);
	if( SUCCEEDED( hr ) ) {
		hr = pVoice->Speak((wchar_t *)_s, 0, NULL);
		pVoice->Release();
		pVoice = NULL;
	} //千万不要忘记：
	::CoUninitialize();
	return 0;
}
将模式改为release，编译。
5.在工程根目录/Release下取出TestTTS.dll放到java工程根目录(也可以放到windows/system32下)
6.执行SpeechSdkTest.java