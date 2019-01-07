package inksci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
    	
    	System.out.println( "Start" );
    	
        try {
            //1.创建客户端Socket，指定服务器地址和端口
        	
            String host = "192.168.43.15";
            int port = 13001;
        	
            Socket socket=new Socket( host , port );
            
            
            // receive
            BufferedReader in = null;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = in.readLine(); // Data should include "\n"
            System.out.println("客户端显示服务器的信息：(data from server:)" + str);
            

            
            /*
            //获取输入流，并读取服务器端的响应信息
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String info=null;
            while((info=br.readLine())!=null){
                System.out.println("我是客户端，服务器说："+info);
            }
            */

            System.out.println( "2938" );
            //获取输出流，向服务器端发送信息
            OutputStream os=socket.getOutputStream();//字节输出流
            PrintWriter pw=new PrintWriter(os);//将输出流包装为打印流
            pw.write("inksci.com http");
            System.out.println( "9263" );
            pw.flush();
            System.out.println( "9283" );
            socket.shutdownOutput();//关闭输出流
            System.out.println( "8273!" );
        	/*
            //获取输出流，向服务器端发送信息
            os=socket.getOutputStream();//字节输出流
            pw=new PrintWriter(os);//将输出流包装为打印流
            pw.write("close");
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            */
            
            //关闭资源
            //br.close();
            //is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println( "finish!" );
        
    }
}
