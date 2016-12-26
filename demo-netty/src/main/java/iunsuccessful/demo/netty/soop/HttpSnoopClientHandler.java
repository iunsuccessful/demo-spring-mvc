package iunsuccessful.demo.netty.soop;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class HttpSnoopClientHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("connection success.");

        // Prepare the HTTP request.
        HttpRequest request = new DefaultFullHttpRequest(
                HttpVersion.HTTP_1_1, HttpMethod.GET, HttpSnoopClient.getURI().getRawPath());
        request.headers().set(HttpHeaderNames.HOST, HttpSnoopClient.getURI().getHost());
        request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
        request.headers().set(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.GZIP);

        ctx.channel().writeAndFlush(request);

        super.channelActive(ctx);
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {

        if (msg instanceof HttpContent) {

            HttpContent content = (HttpContent) msg;

            String message = content.content().toString(CharsetUtil.UTF_8);

            System.out.println(message);
//            List<String> urls = HLSUtils.decode(message);
//            for (int i = 0; i < urls.size(); i++ ) {
//                 下载文件
//                HttpRequestUtils.sendGet(urls.get(i), HttpSnoopClient.getURI().getHost());
//            }

        }
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}