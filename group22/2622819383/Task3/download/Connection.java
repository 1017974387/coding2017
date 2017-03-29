import java.net.URL;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

public class Connection {
    
    private URL url;
    private HttpURLConnection conn;
    private String urlName;
    
    public String getURLName() {
        return urlName;
    }
    
    //����һ��Connection������Ӧ������һ��HttpURLConnection����
    public Connection(String url) {
        urlName = url; 
        try {
            this.url = new URL(urlName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void initConnection() {
        try {
            conn = (HttpURLConnection)url.openConnection(); //throws IOException            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //�ӷ���������startPos-endPos�ֽڷ�Χ����Դ���ݵ�һ���ֽ�����
    public byte[] read(int startPos, int endPos) throws IOException {
        //Range: ���ڿͻ��˵��������˵����󣬿�ͨ�����ֶ�ָ�������ļ���ĳһ�δ�С�����䵥λ��                                          
        initConnection();
        conn.setRequestProperty("Range", "bytes=" + startPos + "-" + endPos);
        InputStream in = conn.getInputStream();             //throws IOException
       
        ByteArrayOutputStream out = new ByteArrayOutputStream();
            
        byte[] buf = new byte[1024];
        int hasRead = 0;        
        while ((hasRead = in.read(buf)) != -1) {
            out.write(buf, 0, hasRead);
        }   
        out.close();
        in.close();
        return out.toByteArray();            
    }
    
    public int getContentLength() {
        initConnection();
        return conn.getContentLength();
    }
    
    public void close() {
        
    }
}