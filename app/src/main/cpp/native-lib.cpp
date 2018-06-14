#include <jni.h>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <termios.h>
#include <sys/mman.h>
#include <errno.h>
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_qoren_1000_myapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_qoren_1000_myapplication_MainActivity_intFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    return 6;
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_qoren_1000_myapplication_MainActivity_LEDControl( JNIEnv* env,jobject thiz, jint data )
{
    int fd,ret;
    ret = 1;

    fd = open("/dev/led",O_WRONLY);
    if(fd < 0) return -errno;
    if(fd > 0) {
        data &= 0xff;
        ret = write(fd,&data,1);
        close(fd);
    } else return fd;

    if(ret == 1) return 0;

    return -1;
}