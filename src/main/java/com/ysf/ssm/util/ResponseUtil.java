package com.ysf.ssm.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Create by Tars on 2017/11/18
 */
public class ResponseUtil {

    public static void write(HttpServletResponse response,Object o) throws IOException {
        response.setContentType( "text/heml;charest=utf-8" );
        response.addHeader( "Access-Control-Allow-Origin","*" );
        PrintWriter out = response.getWriter();
        out.print( o.toString() );
        out.flush();
        out.close();
    }
}
