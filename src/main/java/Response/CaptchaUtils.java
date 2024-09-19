package Response;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class CaptchaUtils {
    // 验证码字符集
    private static final char[] CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    // 图像宽度和高度
    private static final int WIDTH = 80;
    private static final int HEIGHT = 40;
    // 验证码字符个数
    private static final int LENGTH = 4;

    /**
     * 创建验证码图像并返回验证码上的文本
     *
     * @param request  HttpServletRequest, 用于获取会话
     * @param response HttpServletResponse, 用于输出图像到客户端
     * @return 返回生成的验证码文本
     */
    public static String createCaptchaImage(HttpServletRequest request, HttpServletResponse response) {
        // 在这里创建或获取会话
        HttpSession session = request.getSession();

        // 创建BufferedImage对象，作为图像缓冲区
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // 获取Graphics2D对象，用于绘制图像
        Graphics2D g = image.createGraphics();

        // 设置背景色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 设置字体
        g.setFont(new Font("Arial", Font.BOLD, 20));

        // 生成随机验证码
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < LENGTH; i++) {
            char randomChar = CHAR_SET[random.nextInt(CHAR_SET.length)];
            captcha.append(randomChar);
            // 设置字体颜色
            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            g.drawString(String.valueOf(randomChar), 20 * i + 10, 30);
        }

        // 绘制干扰线
        for (int i = 0; i < 10; i++) {
            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            g.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT), random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }

        // 释放Graphics2D对象
        g.dispose();

        // 设置响应头
        response.setContentType("image/jpeg");
        try {
            // 将图像输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());
            // 刷新输出流
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将验证码文本保存到会话中,以便进行验证
        session.setAttribute("captchaText", captcha.toString());

        // 返回生成的验证码文本
        return captcha.toString();
    }
}