package Models;

public class UserSettings {
    private int settingsID;
    private int difficultyID;
    private int musicVol;
    private int soundVol;
    private int screenSizeID;
    private String lastSeed;

    @Override
    public String toString() {
        return "Users{" +
                "settingsID=" + settingsID +
                ", difficultyID=" + difficultyID +
                ", musicVol=" + musicVol +
                ", soundVol=" + soundVol +
                ", screenSizeID=" + screenSizeID +
                ", lastSeed='" + lastSeed + '\'' +
                '}';
    }

    public int getSettingsID() {
        return settingsID;
    }

    public void setSettingsID(int settingsID) {
        this.settingsID = settingsID;
    }

    public int getDifficultyID() {
        return difficultyID;
    }

    public void setDifficultyID(int difficultyID) {
        this.difficultyID = difficultyID;
    }

    public int getMusicVol() {
        return musicVol;
    }

    public void setMusicVol(int musicVol) {
        this.musicVol = musicVol;
    }

    public int getSoundVol() {
        return soundVol;
    }

    public void setSoundVol(int soundVol) {
        this.soundVol = soundVol;
    }

    public int getScreenSizeID() {
        return screenSizeID;
    }

    public void setScreenSizeID(int screenSizeID) {
        this.screenSizeID = screenSizeID;
    }

    public String getLastSeed() {
        return lastSeed;
    }

    public void setLastSeed(String lastSeed) {
        this.lastSeed = lastSeed;
    }

    public UserSettings(int settingsID, int difficultyID, int musicVol, int soundVol, int screenSizeID, String lastSeed) {

        this.settingsID = settingsID;
        this.difficultyID = difficultyID;
        this.musicVol = musicVol;
        this.soundVol = soundVol;
        this.screenSizeID = screenSizeID;
        this.lastSeed = lastSeed;
    }
}
