package pl.ktmc.welcome.utils.center;

import org.bukkit.ChatColor;

public final class Center {

    private Center() {
    }

    public static String sendCenteredString(String message) {
        String[] lines = ChatColor.translateAlternateColorCodes('&', message).split("\n", 40);
        StringBuilder returnMessage = new StringBuilder();
        String[] var3 = lines;
        int var4 = lines.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            String line = var3[var5];
            int messagePxSize = 0;
            boolean previousCode = false;
            boolean isBold = false;
            char[] var10 = line.toCharArray();
            int spaceLength = var10.length;

            int compensated;
            for (compensated = 0; compensated < spaceLength; ++compensated) {
                char c = var10[compensated];
                if (c == 167) {
                    previousCode = true;
                } else if (previousCode) {
                    previousCode = false;
                    isBold = c == 'l';
                } else {
                    DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                    messagePxSize = isBold ? messagePxSize + dFI.getBoldLength() : messagePxSize + dFI.getLength();
                    ++messagePxSize;
                }
            }

            int toCompensate = 154 - messagePxSize / 2;
            spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
            compensated = 0;

            StringBuilder sb;
            for (sb = new StringBuilder(); compensated < toCompensate; compensated += spaceLength) {
                sb.append(" ");
            }

            returnMessage.append(sb.toString()).append(line).append("\n");
        }

        return returnMessage.toString();
    }
}
