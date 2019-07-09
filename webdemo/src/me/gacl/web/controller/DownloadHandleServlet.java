package me.gacl.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jaovo.msg.dao.ResourceDAOImpl;
import com.jaovo.msg.model.Resource;

public class DownloadHandleServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        //�õ�Ҫ���ص��ļ���
//        String fileName = request.getParameter("filename");  //23239283-92489-������.avi
//        fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
//        //�ϴ����ļ����Ǳ�����/WEB-INF/uploadĿ¼�µ���Ŀ¼����
//        String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");
//        //ͨ���ļ����ҳ��ļ�������Ŀ¼
//        String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
//        //�õ�Ҫ���ص��ļ�
//        File file = new File(path + "\\" + fileName);
		String resname =request.getParameter("textValue");
	    System.out.print(resname);
	    ResourceDAOImpl resDao = new ResourceDAOImpl();
	    Resource resLoad=resDao.loadByResname(resname);
	    
		String fileName =resLoad.getResoceName();
		String path=resLoad.getResoceLoc();
		System.out.println(fileName+"hello");
		//String path="E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webdemo\\WEB-INF\\upload\\work.txt";
		File file=new File(path);
        //����ļ�������
        if(!file.exists()){
            request.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ������");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            System.out.println("��Ҫ���ص���Դ�ѱ�ɾ������");
            return;
        }
        //�����ļ���
        String realname = fileName.substring(fileName.indexOf("_")+1);
        //������Ӧͷ��������������ظ��ļ�
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
        //��ȡҪ���ص��ļ������浽�ļ�������
        FileInputStream in = new FileInputStream(path);
        //���������
        OutputStream out = response.getOutputStream();
        //����������
        byte buffer[] = new byte[1024];
        int len = 0;
        //ѭ�����������е����ݶ�ȡ������������
        while((len=in.read(buffer))>0){
            //��������������ݵ��������ʵ���ļ�����
            out.write(buffer, 0, len);
        }
        //�ر��ļ�������
        in.close();
        //�ر������
        out.close();
//        String message="���سɹ�";
//        request.setAttribute("message",message);
        request.getRequestDispatcher("/resDetail.jsp").forward(request, response);
    }
    
    /**
    * @Method: findFileSavePathByFileName
    * @Description: ͨ���ļ����ʹ洢�ϴ��ļ���Ŀ¼�ҳ�Ҫ���ص��ļ�������·��
    * @param filename Ҫ���ص��ļ���
    * @param saveRootPath �ϴ��ļ�����ĸ�Ŀ¼��Ҳ����/WEB-INF/uploadĿ¼
    * @return Ҫ���ص��ļ��Ĵ洢Ŀ¼
    */ 
    public String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        File file = new File(dir);
        if(!file.exists()){
            //����Ŀ¼
            file.mkdirs();
        }
        System.out.print(dir);
        return dir;
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}