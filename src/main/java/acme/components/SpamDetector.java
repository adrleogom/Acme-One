package acme.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpamDetector {
	
	private SpamDetector() {
	    throw new IllegalStateException("Utility class");
	}

	public static boolean spamDetect(String text, final String weakSpamWords, final String strongSpamWords,
		final double weakThreshold, final double strongThreshold ) {
		boolean result = false;
		if(!text.isEmpty()) {
			final List<String> weakList = new ArrayList<String>();
			final List<String> strongList = new ArrayList<String>();
	
			Collections.addAll(weakList, weakSpamWords.trim().split(","));
			Collections.addAll(strongList, strongSpamWords.trim().split(","));
			text = text.toLowerCase();
			text = text.replaceAll("[^a-zA-Z0-9\\s]", "");
			final double percentageWeak = SpamDetector.percentageSpam(text, weakList);
			final double percentageStrong = SpamDetector.percentageSpam(text, strongList);
			if (percentageWeak>weakThreshold || percentageStrong>strongThreshold) {
				result = false;
			}else {
				result = true;
			}
		}
		return result;
	}
	
	private static double percentageSpam(final String text, final List<String> words) {
		double res = 0;
		double aux = 0;
		for (final String w : words) {
			aux = SpamDetector.lockMatch(text, w);
			if(aux>res) {
				res = aux;
			}
		}
		return res;
	}
	private static int lockMatch(final String s, final String t) {



        final int totalw = SpamDetector.wordCount(s);
        final int total = 100;
        final int perw = total / totalw;
        int gotperw = 0;

        if (!s.equals(t)) {

            for (int i = 1; i <= totalw; i++) {
                if (SpamDetector.simpleMatch(SpamDetector.splitString(s, i), t) == 1) {
                    gotperw = ((perw * (total - 10)) / total) + gotperw;
                } else if (SpamDetector.frontFullMatch(SpamDetector.splitString(s, i), t) == 1) {
                    gotperw = ((perw * (total - 20)) / total) + gotperw;
                } else if (SpamDetector.anywhereMatch(SpamDetector.splitString(s, i), t) == 1) {
                    gotperw = ((perw * (total - 30)) / total) + gotperw;
                } else {
                    gotperw = ((perw * SpamDetector.smartMatch(SpamDetector.splitString(s, i), t)) / total) + gotperw;
                }
            }
        } else {
            gotperw = 100;
        }
        return gotperw;
    }

	private static int anywhereMatch(final String s, final String t) {
        int x = 0;
        if (t.contains(s)) {
            x = 1;
        }
        return x;
    }

	private static int frontFullMatch(final String s, final String t) {
        int x = 0;
        String tempt;
        final int len = s.length();

        //----------Work Body----------//
        for (int i = 1; i <= SpamDetector.wordCount(t); i++) {
            tempt = SpamDetector.splitString(t, i);
            if (tempt.length() >= s.length()) {
                tempt = tempt.substring(0, len);
                if (s.contains(tempt)) {
                    x = 1;
                    break;
                }
            }
        }
        //---------END---------------//
        if (len == 0) {
            x = 0;
        }
        return x;
    }

	private static int simpleMatch(final String s, final String t) {
        int x = 0;
        String tempt;
        final int len = s.length();

        
        //----------Work Body----------//
        for (int i = 1; i <= SpamDetector.wordCount(t); i++) {
            tempt = SpamDetector.splitString(t, i);
            if (tempt.length() == s.length() && s.contains(tempt)) {
                x = 1;
                break;
            }
        }
        //---------END---------------//
        if (len == 0) {
            x = 0;
        }
        return x;
    }

	private static int smartMatch(final String ts, final String tt) {

        final char[] s = ts.toCharArray();
        final char[] t = tt.toCharArray();


        final int slen = s.length;
        //number of 3 combinations per word//
        final int combs = (slen - 3) + 1;
        //percentage per combination of 3 characters//
        int ppc = 0;
        if (30 > slen && slen >= 3) {
            ppc = 100 / combs;
        }else if (slen>=30) {
        	ppc = 1;
        }
        //initialising an integer to store the total % this class genrate//
        int x = 0;
        //declaring a temporary new source char array
        final char[] ns = new char[3];
        //check if source char array has more then 3 characters//
        if (slen < 3) {
        } else {
            for (int i = 0; i < combs; i++) {
                for (int j = 0; j < 3; j++) {
                    ns[j] = s[j + i];
                }
                if (SpamDetector.crossFullMatch(ns, t) == 1) {
                    x = x + 1;
                }
            }
        }
        x = ppc * x;
        return x;
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
	private static int  crossFullMatch(final char[] s, final char[] t) {
        final int z = t.length - s.length;
        int x = 0;
        if (s.length > t.length) {
            return x;
        } else {
            for (int i = 0; i <= z; i++) {
                for (int j = 0; j <= (s.length - 1); j++) {
                    if (s[j] == t[j + i]) {
                        // x=1 if any charecer matches
                        x = 1;
                    } else {
                        // if x=0 mean an character do not matches and loop break out
                        x = 0;
                        break;
                    }
                }
                if (x == 1) {
                    break;
                }
            }
        }
        return x;
    }

	private static String splitString(final String s, final int n) {

        int index;
        String temp;
        temp = s;
        String temp2 = "";

        final int temp3 = 0;

        for (int i = 0; i < n; i++) {
            final int strlen = temp.length();
            index = temp.indexOf(" ");
            if (index < 0) {
                index = strlen;
            }
            temp2 = temp.substring(temp3, index);
            temp = temp.substring(index, strlen);
            temp = temp.trim();

        }
        return temp2;
    }

	private static int wordCount(String s) {
        int x = 1;
        int c;
        s = s.trim();
        if (s.isEmpty()) {
            x = 0;
        } else {
            if (s.contains(" ")) {
                for (;;) {
                    x++;
                    c = s.indexOf(" ");
                    s = s.substring(c);
                    s = s.trim();
                    if (s.contains(" ")) {
                    } else {
                        break;
                    }
                }
            }
        }
        return x;
    }
}
