package com.zhuguang.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.zhuguang.upload.config.UploadProperties;
import com.zhuguang.upload.controller.UploadController;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private UploadProperties proper;

    // 支持的文件类型
   // private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg","image/jpg");

    public String upload(MultipartFile file) {
        try {
            // 1、图片信息校验
            // 1)校验文件类型
            String type = file.getContentType();
            if (!proper.getSuffixes().contains(type)) {
                logger.info("上传失败，文件类型不匹配：{}", type);
                return null;
            }
            // 2)校验图片内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            //获得后缀名(.jpg)
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            if (image == null) {
                logger.info("上传失败，文件内容不符合要求");
                return null;
            }
            // 2、保存图片
            // 2.1、生成保存目录
/*            File dir = new File("D:\\heima\\upload");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 2.2、保存图片
            file.transferTo(new File(dir, file.getOriginalFilename()));*/

            // 2.3、拼接图片地址
            /*String url = "http://image.leyou.com/upload/" + file.getOriginalFilename();*/
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            //全路径group1/M00/00/00/wKgBg1wx4U6ATYd2AAEd59tvuiU329.jpg
            String fullPath = storePath.getFullPath();
            String url = proper.getBaseUrl() + fullPath;//返回到前端的具体路径
            return url;
        } catch (Exception e) {
            return null;
        }
    }
}
