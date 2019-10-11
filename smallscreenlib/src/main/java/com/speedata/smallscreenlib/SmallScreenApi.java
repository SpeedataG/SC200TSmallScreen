package com.speedata.smallscreenlib;

/**
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 *
 * @author :EchoXBR in  2019-10-10 19:50.
 * 功能描述:SC200T 小屏幕API封装
 */
public class SmallScreenApi {

    static {
        System.loadLibrary("smallscreen");
    }

    /**
     *
     * @param x 坐标x：0-127, 16号汉字每行最多可以显示8个，24号汉字则是5个
     * @param y 坐标y：0-7， 即纵轴被平均分成8份，数值代表每份的起点
     * @param data content：待显示的内容，gb2312汉字编码的code值
     * @param front 字体大小，当前项目是16或24，若传入的值是0，则进行清屏的操作。
     */
    public void WriteData(int x, int y, byte[] data, int front) {
        write_sublcd(x, y, data, front);
    }

    private native void write_sublcd(int x, int y, byte[] data, int front);
}
