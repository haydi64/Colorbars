/*--------------------------
 *Hayden Ivatts
 *hpivat21@g.holycross.edu
 *2-26-18
 *
 *The program creates an SMPTE image
 *using dimensions that the user enters.
 *The user also chooses if they want the bright
 * or dim version of the image. Finally, the image is
 *displayed and saved to a file name the user chooses
 *
 *java Colorbars  smpte.png  240  dim
 *
 *---------------*/

import java.awt.Color;//Import Color class

public class Colorbars {
    public static void main(String[] args) {
        //Verifies that the user entered the correct number of arguments
        if (args.length < 3) {
            System.out.print("Sorry you have not entered a valid number of arguments.");
            System.out.println("The correct format is java Colorbars smpte.png 240 dim");
            System.exit(1);
        }
        
        //Verifies that the width entered is a multiple of 16, not 0, and positive
        if (Integer.parseInt(args[1]) <= 0 || (Integer.parseInt(args[1]) % 16) != 0) {
            System.out.println("Sorry the width you entered is not valid. The number must be a multiple of 16, not 0, and positive");
            System.exit(1);
        }
        
        //Checks if image color argument is valid
        if (!(args[2].equals("dim")) && !(args[2].equals("bright"))) {
            System.out.println("The image colors you entered are invalid. You must enter either dim or bright, case sensitive.");
            System.exit(0);
        }

        int totalwidth = Integer.parseInt(args[1]);//Varibale for width of whole image
        
        int totalheight = (int)(totalwidth * .75);//Variable for height of whole image

        Picture smpte = new Picture(totalwidth, totalheight);//Creates image of dimensions entered by user
        
        Color darkpurple = new Color(50, 0, 106);//Sets dark purple color for dim and bright
        
        Color darkblue = new Color(0, 33, 76);//Sets dark blue color for dim and bright

        Color white = new Color(255, 255, 255);//Sets white color for dim and bright

        Color black = new Color(0, 0, 0);//Sets black color for dim and bright

        int lum;//Variable representing the luminance for either dim or bright
       
        if (args[2].equals("dim")) {
            lum = 192;
        } else {
            lum = 255;
        }

        Color gray = new Color(lum, lum, lum);//Sets gray color based on dim or bright entry

        Color yellow = new Color(lum, lum, 0);//Sets yello color based on dim or bright entry

        Color cyan = new Color(0, lum, lum);//Sets cyan color based on dim or bright entry

        Color green = new Color(0, lum, 0);//Sets green color based on dim or bright entry

        Color magenta = new Color(lum, 0, lum);//Sets magenta color based on dim or bright entry

        Color red = new Color(lum, 0, 0);//Sets red color based on dim or bright entry

        Color blue = new Color(0, 0, lum);//Sets blue color based on dim or bright entry

        int topheight = (int)((totalheight / 3.0) * 2.0);//Calculates where top section should end

        int topbarwidth = (int)((totalwidth / 7.0)) + 1;//Calculates how wide the bars for the middle and top sections should be. Adds one to account for rounding.

        //Creates top section of SMPTE image
        for (int i = 0; i < topheight; i++) {
            for (int j = 0; j < totalwidth; j++) {
                if (j < topbarwidth) {
                    smpte.set(j, i, gray);
                }

                if (j >= topbarwidth && j < (topbarwidth * 2)) {
                    smpte.set(j, i, yellow);
                }

                if (j >= (topbarwidth * 2) && j < (topbarwidth * 3)) {
                    smpte.set(j, i, cyan);
                }
                
                if (j >= (topbarwidth * 3) && j < (topbarwidth * 4)) {
                    smpte.set(j, i, green);
                }
                
                if (j >= (topbarwidth * 4) && j < (topbarwidth * 5)) {
                    smpte.set(j, i, magenta);
                }
                
                if (j >= (topbarwidth * 5) && j < (topbarwidth * 6)) {
                    smpte.set(j, i, red);
                }
                
                if (j >= (topbarwidth * 6) && j < (topbarwidth * 7)) {
                    smpte.set(j, i, blue);
                }
            }
        }

        int middleheight = topheight + (int)(totalheight / 12.0);//Calculates where the middle section should end

        //Creates middle section of SMPTE image
        for (int i = topheight; i < middleheight; i++) {
            for (int j = 0; j < totalwidth; j++) {
                if (j < topbarwidth) {
                    smpte.set(j, i, blue);
                }

                if (j >= topbarwidth && j < (topbarwidth * 2)) {
                    smpte.set(j, i, black);
                }

                if (j >= (topbarwidth * 2) && j < (topbarwidth * 3)) {
                    smpte.set(j, i, magenta);
                }

                if (j >= (topbarwidth * 3) && j < (topbarwidth * 4)) {
                    smpte.set(j, i, black);
                }

                if (j >= (topbarwidth * 4) && j < (topbarwidth * 5)) {
                    smpte.set(j, i, cyan);
                }

                if (j >= (topbarwidth * 5) && j < (topbarwidth * 6)) {
                    smpte.set(j, i, black);
                }
                
                if (j >= (topbarwidth * 6) && j < (topbarwidth * 7)) {
                    smpte.set(j, i, gray);
                }
            }
        }

        int endwidth = (int)(totalwidth / 6.0);//Calculates width of bottom section bars

        for (int i = middleheight; i < totalheight; i++) {
            for (int j = 0; j < totalwidth; j++) {
                if (j < endwidth) {
                    smpte.set(j, i, darkblue);
                }

                if (j > endwidth && j < (endwidth * 2)) {
                    smpte.set(j, i, white);
                }

                if (j > (endwidth * 2) && j < (endwidth * 3)) {
                    smpte.set(j, i, darkpurple);
                }

                if (j > (endwidth * 3)) {
                    smpte.set(j, i, black);
                }   
            }
        }
        
        //displays completed image
        smpte.show();
        
        //saves image to file name that user enters
        smpte.save(args[0]);
    }//end main
}//end class Colorbars


        

        
