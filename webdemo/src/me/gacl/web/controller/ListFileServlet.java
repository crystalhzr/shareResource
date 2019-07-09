package me.gacl.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @ClassName: ListFileServlet
* @Description: �г�Webϵͳ�����������ļ�
* @author: �°�����
* @date: 2015-1-4 ����9:54:40
*
*/ 
public class ListFileServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //��ȡ�ϴ��ļ���Ŀ¼
        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //�洢Ҫ���ص��ļ���
        Map<String,String> fileNameMap = new HashMap<String,String>();
        //�ݹ����filepathĿ¼�µ������ļ���Ŀ¼�����ļ����ļ����洢��map������
        listfile(new File(uploadFilePath),fileNameMap);//File�ȿ��Դ���һ���ļ�Ҳ���Դ���һ��Ŀ¼
        //��Map���Ϸ��͵�listfile.jspҳ�������ʾ
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/listfile.jsp").forward(request, response);
    }
    
    /**
    * @Method: listfile
    * @Description: �ݹ����ָ��Ŀ¼�µ������ļ�
    * @param file ������һ���ļ���Ҳ����һ���ļ�Ŀ¼
    * @param map �洢�ļ�����Map����
    */ 
    public void listfile(File file,Map<String,String> map){
        //���file����Ĳ���һ���ļ�������һ��Ŀ¼
        if(!file.isFile()){
            //�г���Ŀ¼�µ������ļ���Ŀ¼
            File files[] = file.listFiles();
            //����files[]����
            for(File f : files){
                //�ݹ�
                listfile(f,map);
            }
        }else{
            /**
             * �����ļ������ϴ�����ļ�����uuid_�ļ�������ʽȥ���������ģ�ȥ���ļ�����uuid_����
                file.getName().indexOf("_")�����ַ����е�һ�γ���"_"�ַ���λ�ã�����ļ��������ڣ�9349249849-88343-8344_��_��_��.avi
                ��ôfile.getName().substring(file.getName().indexOf("_")+1)����֮��Ϳ��Եõ���_��_��.avi����
             */
            String realName = file.getName().substring(file.getName().indexOf("_")+1);
            //file.getName()�õ������ļ���ԭʼ���ƣ����������Ψһ�ģ���˿�����Ϊkey��realName�Ǵ����������ƣ��п��ܻ��ظ�
            map.put(file.getName(), realName);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}