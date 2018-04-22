/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaImages;

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
public class ImageProcessing_OpenImageTest {
    
    public ImageProcessing_OpenImageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


/**
 * Check that no failure if the directory is incorrect
 */
    @Test
    public void testExtractLocalImageName() {
        String correctImagePath="C:\\Users\\Luis\\Documents\\NetBeansProjects\\JavaImages\\JavaImages\\src\\JavaImages\\Lena.bmp";
        String emptyImagePath = "";
        String incorrectImagePath="incorrectPath";
        String whithoutExtensionImagePath="C:\\documents\\image1";
        
        String correctExpResult="Lena.bmp";
        String emptyExpResult="";
        String incorrectExpResult="incorrectPath";
        String withouhtExtensionExpResult="image1";
        
        String result;
        
        ImageProcessing_OpenImage instance = new ImageProcessing_OpenImage();
      
        result= instance.extractLocalImageName(correctImagePath);
        assertEquals(correctExpResult, result);
        
        result= instance.extractLocalImageName(emptyImagePath);
        assertEquals(emptyExpResult, result);
        
        result= instance.extractLocalImageName(incorrectImagePath);
        assertEquals(incorrectExpResult, result);
        
        result= instance.extractLocalImageName(whithoutExtensionImagePath);
        assertEquals(withouhtExtensionExpResult, result);
    }

    /**
     * Check that no failure if the URL is incorrect
     */
    @Test
    public void testExtractRemoteImageName() {
        System.out.println("extractRemoteImageName");
        String correctImagePath="http://3.bp.blogspot.com/-rxyhDjm7EsI/UN317Ih0rjI/AAAAAAAAPgo/DFsDe1TY3sk/s320/java.jpg";
        String emptyImagePath = "";
        String incorrectImagePath="incorrectPath";
        String whithoutExtensionImagePath="http://3.bp.blogspot.com/-rxyhDjm7EsI/UN317Ih0rjI/AAAAAAAAPgo/DFsDe1TY3sk/s320/java";
        
        String correctExpResult="java.jpg";
        String emptyExpResult="";
        String incorrectExpResult="incorrectPath";
        String withouhtExtensionExpResult="java";
        
        String result;
        
        ImageProcessing_OpenImage instance = new ImageProcessing_OpenImage();
      
        result= instance.extractRemoteImageName(correctImagePath);
        assertEquals(correctExpResult, result);
        
        result= instance.extractRemoteImageName(emptyImagePath);
        assertEquals(emptyExpResult, result);
        
        result= instance.extractRemoteImageName(incorrectImagePath);
        assertEquals(incorrectExpResult, result);
        
        result= instance.extractRemoteImageName(whithoutExtensionImagePath);
        assertEquals(withouhtExtensionExpResult, result);
    }

/**
 * Check that no failure if the URL is incorrect
 */
    @Test
    public void testOpenUrl() {
        System.out.println("openUrl");
        
        String correctUrlImage = "http://3.bp.blogspot.com/-rxyhDjm7EsI/UN317Ih0rjI/AAAAAAAAPgo/DFsDe1TY3sk/s320/java.jpg";
        String incorrectUrlImage="incorrectUrl";
        
       ImageProcessing_OpenImage instance = new ImageProcessing_OpenImage();
       
       assertNotNull(instance.openUrl(correctUrlImage));
       assertNull(instance.openUrl(incorrectUrlImage));

    }
}