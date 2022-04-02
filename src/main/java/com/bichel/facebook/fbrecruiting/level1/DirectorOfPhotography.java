package com.bichel.facebook.fbrecruiting.level1;

/*
https://www.facebookrecruiting.com/portal/coding_puzzles/?puzzle=870874083549040&source=career_site_login_panel_sign_up_button
 */

public class DirectorOfPhotography {
    public int getArtisticPhotographCount(int N, String C, int X, int Y) {
        int i = 0;
        while (i < N && C.charAt(i) != 'A') {
            i++;
        }

        if (i == N) {
            return 0;
        }

        Window leftWindow = new Window();
        for (int leftIndex = i - X; leftIndex >= i - Y && leftIndex >= 0; leftIndex--) {
            char type = C.charAt(leftIndex);
            leftWindow.incrementIfMatch(type);
        }

        Window rightWindow = new Window();
        for (int rightIndex = i + X; rightIndex <= i + Y && rightIndex < N; rightIndex++) {
            char type = C.charAt(rightIndex);
            rightWindow.incrementIfMatch(type);
        }

        int count = 0;

        while (i < N) {
            if (C.charAt(i) == 'A') {
                count += leftWindow.photographers * rightWindow.backdrops + leftWindow.backdrops * rightWindow.photographers;
            }

            if (i - Y >= 0) {
                char typeExitingWindow = C.charAt(i - Y);
                leftWindow.decrementIfMatch(typeExitingWindow);
            }

            if (i - X + 1 >= 0) {
                char typeEnteringWindow = C.charAt(i - X + 1);
                leftWindow.incrementIfMatch(typeEnteringWindow);
            }

            if (i + X < N) {
                char typeExitingWindow = C.charAt(i + X);
                rightWindow.decrementIfMatch(typeExitingWindow);
            }

            if (i + Y + 1 < N) {
                char typeEnteringWindow = C.charAt(i + Y + 1);
                rightWindow.incrementIfMatch(typeEnteringWindow);
            }

            i++;
        }

        return count;
    }
}

class Window {
    long photographers;
    long backdrops;

    void incrementIfMatch(char type) {
        updateIfMatch(type, 1);
    }

    void decrementIfMatch(char type) {
        updateIfMatch(type, -1);
    }

    private void updateIfMatch(char type, int addValue) {
        if (type == 'P') {
            photographers += addValue;
        } else if (type == 'B') {
            backdrops += addValue;
        }
    }
}
