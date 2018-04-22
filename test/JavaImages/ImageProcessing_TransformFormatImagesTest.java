/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaImages;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis
 */
public class ImageProcessing_TransformFormatImagesTest {
    
    public ImageProcessing_TransformFormatImagesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.bufferImage=new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        this.image=(Image)bufferImage;
        this.imageIcon=new ImageIcon(image);
        this.jLabel1=new JLabel();
        this.jLabel1.setIcon(imageIcon);
        this.icon=jLabel1.getIcon();
    }
    
    @After
    public void tearDown() {
    }

    private Image image;
    private BufferedImage bufferImage;
    private ImageIcon imageIcon;
    private Icon icon;
    private JLabel jLabel1;
    
    @Test
    public void testAllTestTransform() {
        ImageProcessing_TransformFormatImages instance=new ImageProcessing_TransformFormatImages();
        
        assertNotNull(instance.bufferedImageToIcon(bufferImage)); 
        instance.bufferedImageToIcon(bufferImage);
        instance.bufferedImageToImage(bufferImage);
        instance.bufferedImageToImageIcon(bufferImage);
        
        instance.iconToBufferedImage(icon);
        instance.iconToImage(icon);
        instance.iconToImageIcon(icon);
        
        instance.imageToBufferedImage(image);
        instance.imageToIcon(image);
        instance.imageToImageIcon(image);
        
        instance.imageIconToImage(imageIcon);
        instance.imageIconToIcon(imageIcon);
        instance.imageIconToBufferedImage(imageIcon);
        
    }

}