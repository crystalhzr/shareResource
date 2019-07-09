package me.gacl.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jaovo.msg.model.Resource;
import com.jaovo.msg.dao.ResourceDAOImpl;

public class UploadHandleServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                //�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
                String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
                File file = new File(savePath);
                //�ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
                if (!file.exists() && !file.isDirectory()) {
                    System.out.println(savePath+"Ŀ¼�����ڣ���Ҫ����");
                    //����Ŀ¼
                    file.mkdir();
                }
                //��Ϣ��ʾ
                String message = "";
                String filename="";
                ArrayList<String> formData=new ArrayList<String>();
                try{
                    //ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
                    //1������һ��DiskFileItemFactory����
                    DiskFileItemFactory factory = new DiskFileItemFactory();
                    //2������һ���ļ��ϴ�������
                    ServletFileUpload upload = new ServletFileUpload(factory);
                     //����ϴ��ļ�������������
                    upload.setHeaderEncoding("UTF-8"); 
                    //3���ж��ύ�����������Ƿ����ϴ���������
                    if(!ServletFileUpload.isMultipartContent(request)){
                        //���մ�ͳ��ʽ��ȡ����
                        return;
                    }
                    //4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
                    List<FileItem> list = upload.parseRequest(request);         
                    System.out.println(list);
                    for(FileItem item : list){
                        //���fileitem�з�װ������ͨ�����������
                        if(item.isFormField()){
                            String name = item.getFieldName();
                            //�����ͨ����������ݵ�������������
                            String value = item.getString("UTF-8");
                            //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                            formData.add(value);
                            System.out.println(name + "=" + value);
                        }else{//���fileitem�з�װ�����ϴ��ļ�
                            //�õ��ϴ����ļ����ƣ�
                            filename = item.getName();
                            System.out.println(filename);
                            if(filename==null || filename.trim().equals("")){
                                continue;
                            }
                            //ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
                            //�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
                            filename = filename.substring(filename.lastIndexOf("\\")+1);
                            //��ȡitem�е��ϴ��ļ���������
                            InputStream in = item.getInputStream();
                            //����һ���ļ������
                            FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                            //����һ��������
                            byte buffer[] = new byte[1024];
                            //�ж��������е������Ƿ��Ѿ�����ı�ʶ
                            int len = 0;
                            //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
                            while((len=in.read(buffer))>0){
                                //ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
                                out.write(buffer, 0, len);
                            }
                            //�ر�������
                            in.close();
                            //�ر������
                            out.close();
                            //ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
                            item.delete();
                            message = "�ļ��ϴ��ɹ���";
                            formData.add(savePath + "\\" + filename);
                            System.out.println(savePath + "\\" + filename);                                                        
                        }
                    }
                }catch (Exception e) {
                    message= "�ļ��ϴ�ʧ�ܣ�";
                    e.printStackTrace();
                }
                Resource resource=new Resource();
                resource.setType(formData.get(0));
                resource.setResoceAuthor(formData.get(1));
                resource.setResoceName(formData.get(2));
                resource.setTitle(formData.get(3));
                resource.setDescribe(formData.get(4));
                resource.setDate(formData.get(5));
		/*
		 * DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); try {
		 * resource.date=format1.parse(formData.get(5)); } catch (ParseException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
                resource.setResoceLoc(formData.get(6));
                ResourceDAOImpl resDaoImpl=new ResourceDAOImpl();
                resDaoImpl.add(resource);                
                request.setAttribute("message",message);
                request.getRequestDispatcher("/upload.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}