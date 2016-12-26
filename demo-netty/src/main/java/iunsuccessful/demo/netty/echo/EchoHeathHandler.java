package iunsuccessful.demo.netty.echo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

/**
 * @author LiQZ on 2016/7/29.
 */
public class EchoHeathHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Heartbeat!", StandardCharsets.UTF_8));
        super.userEventTriggered(ctx, evt);
    }
}
