
public class validIP {

    public static String whichType(String IP) {
        if (IP == null || IP.length() == 0) {
            return "neither";
        }
        if (IP.contains(".")) {
            String[] parts = IP.split("\\.", -1);
            if (parts.length != 4) {
                return "neither";
            }
            for (String part : parts) {
                if (part.isEmpty() || part.length() > 3) {
                    return "neither";
                }
                if (!part.matches("\\d+")) {
                    return "neither";
                }
                if (part.charAt(0) == '0' && part.length() > 1) {
                    return "neither";
                }
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return "neither";
                }
            }
            return "IPv4";
        } else if (IP.contains(":")) {
            String[] parts = IP.split(":");
            if (parts.length != 8) {
                return "neither";
            }
            for (String part : parts) {
                if (part.isEmpty() || part.length() > 4) {
                    return "neither";
                }
                if (!part.matches("[0-9a-fA-F]+")) {
                    return "neither";
                }

            }
            return "IPv6";
        }
        return "neither";

    }

    public static void main(String[] args) {
        String IP1 = "0.0.0.0";
        String IP2 = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        String IP3 = "256.256.256.256";
        System.out.println(whichType(IP1));
        System.out.println(whichType(IP2));
        System.out.println(whichType(IP3));
    }

}
