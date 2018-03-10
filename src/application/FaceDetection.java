package application;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;


public  class FaceDetection {
	public static String path = "C://InternshipER//camera//temp//img.png";
	public static int detectFaces() {
	    System.out.println("\nRunning DetectFaceDemo");
            int i = 0;
	    // Create a face detector from the cascade file in the resources
	    // directory.
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    CascadeClassifier faceDetector = new CascadeClassifier("src\\lbpcascade_frontalface.xml");
	    Mat image = Imgcodecs.imread(path);

	    // Detect faces in the image.
	    // MatOfRect is a special container class for Rect.
	    MatOfRect faceDetections = new MatOfRect();
	    faceDetector.detectMultiScale(image, faceDetections);
	    
	    System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

	    // Draw a bounding box around each face.
	    for (Rect rect : faceDetections.toArray()) {
	        Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
	    }

	    // Save the visualized detection.
            String filename;
            int faceNumber = faceDetections.toArray().length;
            if(faceNumber <= 1){
                 filename = "C://InternshipER//camera//faceDetection_"+i+".png";
                 i++;
            }
            
            else {
                 filename = "C://InternshipER//camera//flagged//faceDetection_"+i+".png";
                 i++;
            }
	   
	    System.out.println(String.format("Writing %s", filename));
	    Imgcodecs.imwrite(filename, image);
	    return faceDetections.toArray().length;
            
	  }
}
