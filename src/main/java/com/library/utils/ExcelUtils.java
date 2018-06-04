//package com.library.utils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Description: excel报表工具类
// */
//public class ExcelUtils {
//    //excel默认宽度；
//    private static int width = 256*14;
//    //默认字体
//    private static String excelfont = "微软雅黑";
//
//    /**
//     *
//     * @param excelName  导出的EXCEL名字
//     * @param sheetName  导出的SHEET名字  当前sheet数目只为1
//     * @param headers      导出的表格的表头
//     * @param ds_titles      导出的数据 map.get(key) 对应的 key
//     * @param ds_format    导出数据的样式
//     *                          1:String left;
//     *                          2:String center
//     *                          3:String right
//     *                          4 int  right
//     *                          5:float ###,###.## right
//     *                          6:number: #.00% 百分比 right
//     * @param widths      表格的列宽度  默认为 256*14
//     * @param data        数据集  List<Map>
//     * @param response
//     * @throws IOException
//     */
//    public static void export(String excelName, String sheetName, String[] headers, String[] ds_titles, int[] ds_format, int[] widths, List<Map<String,Object>> data , HttpServletRequest request, HttpServletResponse response) throws IOException {
//        HttpSession session = request.getSession();
//        session.setAttribute("state", null);
//        if(widths==null){
//            widths = new int[ds_titles.length];
//            for(int i=0;i<ds_titles.length;i++){
//                widths[i]=width;
//            }
//        }
//        if(ds_format==null){
//            ds_format = new int[ds_titles.length];
//            for(int i=0;i<ds_titles.length;i++){
//                ds_format[i]=1;
//            }
//        }
//        //设置文件名
//        String fileName = "";
//        if(StringUtils.isNotEmpty(excelName)){
//            fileName = excelName;
//        }
//        //创建一个工作薄
//        HSSFWorkbook wb = new HSSFWorkbook();
//        //创建一个sheet
//        HSSFSheet  sheet = wb.createSheet(StringUtils.isNotEmpty(sheetName)?sheetName:"excel");
//        //创建表头，如果没有跳过
//        int headerrow = 0;
//        if(headers!=null){
//            HSSFRow  row = sheet.createRow(headerrow);
//            //表头样式
//            HSSFCellStyle style = wb.createCellStyle();
//            HSSFFont font = wb.createFont();
//            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//            font.setFontName(excelfont);
//            font.setFontHeightInPoints((short) 11);
//            style.setFont(font);
//            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
//            for (int i = 0; i < headers.length; i++) {
//                sheet.setColumnWidth((short)i,(short)widths[i]);
//                HSSFCell cell = row.createCell(i);
//                cell.setCellValue(headers[i]);
//                cell.setCellStyle(style);
//            }
//            headerrow++;
//        }
//        //表格主体  解析list
//        if(data != null){
//            List styleList = new ArrayList();
//
//            for (int i = 0; i <ds_titles.length; i++) {  //列数
//                HSSFCellStyle style = wb.createCellStyle();
//                HSSFFont font = wb.createFont();
//                font.setFontName(excelfont);
//                font.setFontHeightInPoints((short) 10);
//                style.setFont(font);
//                style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//                style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//                style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//                style.setBorderTop(HSSFCellStyle.BORDER_THIN);
//                if(ds_format[i]==1){
//                    style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
//                }else if(ds_format[i]==2){
//                    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//                }else if(ds_format[i]==3){
//                    style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
//                    //int类型
//                }else if(ds_format[i]==4){
//                    style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
//                    //int类型
//                    style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
//                }else if(ds_format[i]==5){
//                    //float类型
//                    style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
//                    style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
//                }else if(ds_format[i]==6){
//                    //百分比类型
//                    style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
//                    style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));
//                }
//                styleList.add(style);
//            }
//            for (int i = 0; i < data.size() ; i++) {  //行数
//                HSSFRow  row = sheet.createRow(headerrow);
//                Map map = data.get(i);
//                for (int j = 0; j <ds_titles.length; j++) {  //列数
//                    HSSFCell cell = row.createCell(j);
//                    Object o = map.get(ds_titles[j]);
//                    if(o==null||"".equals(o)){
//                        cell.setCellValue("");
//                    }else if(ds_format[j]==4){
//                        //int
//                        cell.setCellValue((Long.valueOf((map.get(ds_titles[j]))+"")).longValue());
//                    }else if(ds_format[j]==5|| ds_format[j]==6){
//                        //float
//                        cell.setCellValue((Double.valueOf((map.get(ds_titles[j]))+"")).doubleValue());
//                    }else {
//                        cell.setCellValue(map.get(ds_titles[j])+"");
//                    }
//
//                    cell.setCellStyle((HSSFCellStyle)styleList.get(j));
//                }
//                headerrow++;
//            }
//        }
//
//        fileName=fileName+".xls";
//        String filename = "";
//        try{
//            filename =encodeChineseDownloadFileName(request,fileName);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
////          final String userAgent = request.getHeader("USER-AGENT");
////            if(userAgent.indexOf( "MSIE")!=-1){//IE浏览器
////              filename = URLEncoder.encode(fileName,"UTF8");
////            }else if(userAgent.indexOf( "Mozilla")!=-1){//google,火狐浏览器
////              filename = new String(fileName.getBytes(), "ISO8859-1");
////            }else{
////              filename = URLEncoder.encode(fileName,"UTF8");//其他浏览器
////            }
//
//        response.setHeader("Content-disposition", filename);
//        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-disposition", "attachment;filename="+filename);
//        response.setHeader("Pragma", "No-cache");
//        OutputStream ouputStream = response.getOutputStream();
//        wb.write(ouputStream);
//        ouputStream.flush();
//        ouputStream.close();
//        session.setAttribute("state", "open");
//
//    }
//
//    /**
//     * 对文件流输出下载的中文文件名进行编码 屏蔽各种浏览器版本的差异性
//     * @throws UnsupportedEncodingException
//     */
//    public static String encodeChineseDownloadFileName(
//            HttpServletRequest request, String pFileName) throws Exception {
//
//        String filename = null;
//        String agent = request.getHeader("USER-AGENT");
//        if (null != agent){
//            if (-1 != agent.indexOf("Firefox")) {//Firefox
//                filename = "=?UTF-8?B?" + (new String(org.apache.commons.codec.binary.Base64.encodeBase64(pFileName.getBytes("UTF-8"))))+ "?=";
//            }else if (-1 != agent.indexOf("Chrome")) {//Chrome
//                filename = new String(pFileName.getBytes(), "ISO8859-1");
//            } else {//IE7+
//                filename = java.net.URLEncoder.encode(pFileName, "UTF-8");
//                filename = filename.replace("+", "%20");
//            }
//        } else {
//            filename = pFileName;
//        }
//        return filename;
//    }
//}
