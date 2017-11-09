package Models;

public class ScreenSize {
    private int screenSizeID;
    private int width;

    @Override
    public String toString() {
        return "ScreenSize{" +
                "screenSizeID=" + screenSizeID +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    private int height;

    public void setScreenSizeID(int screenSizeID) {
        this.screenSizeID = screenSizeID;
    }

    public int getScreenSizeID() {

        return screenSizeID;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ScreenSize(int screenSizeID, int width, int height) {

        this.screenSizeID = screenSizeID;
        this.width = width;
        this.height = height;
    }
}
