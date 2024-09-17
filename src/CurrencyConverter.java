
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyConverter {

    public static HashMap<String, String> countryCurrencyMap;

    // I know this is dumb, but I've got a deadline and no ideas
    public static String[] allCountries = {
            "germany", "france", "spain", "italy", "portugal",
            "netherlands", "greece", "belgium", "ireland", "austria",
            "slovenia", "slovakia", "cyprus", "latvia", "malta",
            "lithuania", "cyprus", "estonia", "finland", "luxembourg",
            "europe", "united kingdom", "england", "britain", "scotland", "jersey",
            "guemsey", "gibraltar", "wales", "isle of man",
            "saint helena ascension and tristan da cunha",
            "south georgia and the south sandwich islands",
            "united kingdom", "england", "britain", "scotland", "jersey",
            "guemsey", "gibraltar", "wales", "isle of man",
            "saint helena ascension and tristan da cunha",
            "south georgia and the south sandwich islands", "india", "usa", "united states"
    };

    static {
        countryCurrencyMap = new HashMap<String, String>();


        String[] euroCountries = { "germany", "france", "spain", "italy", "portugal",
                "netherlands", "greece", "belgium", "ireland", "austria",
                "slovenia", "slovakia", "cyprus", "latvia", "malta",
                "lithuania", "cyprus", "estonia", "finland", "luxembourg",
                "europe" };


        String[] gbpCountries = { "united kingdom", "england", "britain", "scotland", "jersey",
                "guemsey", "gibraltar", "wales", "isle of man",
                "saint helena ascension and tristan da cunha",
                "south georgia and the south sandwich islands" /* what */};


        String[] usdCountries = { "united states", "usa" };

        // Java has this apparently
        for (String country : euroCountries) {
            countryCurrencyMap.put(country, "EUR");
        }

        for (String country : gbpCountries) {
            countryCurrencyMap.put(country, "GBP");
        }

        for (String country : usdCountries) {
            countryCurrencyMap.put(country, "USD");
        }


        countryCurrencyMap.put("south korea", "KRW");
        countryCurrencyMap.put("korea", "KRW");
        countryCurrencyMap.put("japan", "JPY");
        countryCurrencyMap.put("united arab emirates", "AED");
        countryCurrencyMap.put("afghanistan", "AFN");
        countryCurrencyMap.put("albania", "ALL");
        countryCurrencyMap.put("armenia", "AMD");
        countryCurrencyMap.put("republic of artsakh", "AMD");
        countryCurrencyMap.put("egypt", "EGP");
        countryCurrencyMap.put("russia", "RUB");
        countryCurrencyMap.put("india", "INR");
        countryCurrencyMap.put("bhutan", "INR");
        countryCurrencyMap.put("cryptoland", "BTC");
        countryCurrencyMap.put("the bahamas", "BSD");

    }

    public static String GetCurrencyCode(String country) {
        System.out.println(country);
        if (countryCurrencyMap.containsKey(country)) {
            return countryCurrencyMap.get(country);
        } else {
            throw new IllegalArgumentException("Unknown country: " + country);
        }
    }

    public static double GetRate(String currency){

        var conversionData = """
                {
                  "disclaimer": "Usage subject to terms: https://openexchangerates.org/terms",
                  "license": "https://openexchangerates.org/license",
                  "timestamp": 1725904800,
                  "base": "USD",
                  "rates": {
                    "AED": 3.67297,
                    "AFN": 70.240262,
                    "ALL": 90.246338,
                    "AMD": 387.086887,
                    "ANG": 1.801979,
                    "AOA": 926.2,
                    "ARS": 957.6807,
                    "AUD": 1.501332,
                    "AWG": 1.8025,
                    "AZN": 1.7,
                    "BAM": 1.771293,
                    "BBD": 2,
                    "BDT": 119.481787,
                    "BGN": 1.7698,
                    "BHD": 0.37689,
                    "BIF": 2888,
                    "BMD": 1,
                    "BND": 1.30701,
                    "BOB": 6.909262,
                    "BRL": 5.5886,
                    "BSD": 1,
                    "BTC": 0.000017691833,
                    "BTN": 83.935892,
                    "BWP": 13.367446,
                    "BYN": 3.271993,
                    "BZD": 2.015396,
                    "CAD": 1.355875,
                    "CDF": 2841.5,
                    "CHF": 0.848293,
                    "CLF": 0.03421,
                    "CLP": 943.96,
                    "CNH": 7.11698,
                    "CNY": 7.1136,
                    "COP": 4212.08,
                    "CRC": 526.170275,
                    "CUC": 1,
                    "CUP": 25.75,
                    "CVE": 100.125,
                    "CZK": 22.684999,
                    "DJF": 177.5,
                    "DKK": 6.756467,
                    "DOP": 59.775,
                    "DZD": 132.539981,
                    "EGP": 48.3573,
                    "ERN": 15,
                    "ETB": 113.637971,
                    "EUR": 0.905506,
                    "FJD": 2.2218,
                    "FKP": 0.764307,
                    "GBP": 0.764307,
                    "GEL": 2.69,
                    "GGP": 0.764307,
                    "GHS": 15.67,
                    "GIP": 0.764307,
                    "GMD": 70.5,
                    "GNF": 8627.5,
                    "GTQ": 7.73902,
                    "GYD": 209.188751,
                    "HKD": 7.796845,
                    "HNL": 24.86,
                    "HRK": 6.820692,
                    "HTG": 131.543162,
                    "HUF": 359.234777,
                    "IDR": 15456.351932,
                    "ILS": 3.7667,
                    "IMP": 0.764307,
                    "INR": 83.95865,
                    "IQD": 1309.795848,
                    "IRR": 42105,
                    "ISK": 137.91,
                    "JEP": 0.764307,
                    "JMD": 156.985952,
                    "JOD": 0.7087,
                    "JPY": 142.818,
                    "KES": 129,
                    "KGS": 84.2,
                    "KHR": 4074.430576,
                    "KMF": 445.5,
                    "KPW": 900,
                    "KRW": 1342.333997,
                    "KWD": 0.305315,
                    "KYD": 0.833167,
                    "KZT": 478.790302,
                    "LAK": 22127.5,
                    "LBP": 89600,
                    "LKR": 300.692022,
                    "LRD": 195.169994,
                    "LSL": 17.916448,
                    "LYD": 4.765,
                    "MAD": 9.732,
                    "MDL": 17.344645,
                    "MGA": 4548.185827,
                    "MKD": 55.678482,
                    "MMK": 2098,
                    "MNT": 3398,
                    "MOP": 8.029378,
                    "MRU": 39.72,
                    "MUR": 46.070002,
                    "MVR": 15.35,
                    "MWK": 1733.603781,
                    "MXN": 19.863141,
                    "MYR": 4.3715,
                    "MZN": 63.899993,
                    "NAD": 17.916448,
                    "NGN": 1647.5,
                    "NIO": 36.8025,
                    "NOK": 10.825932,
                    "NPR": 134.296598,
                    "NZD": 1.62599,
                    "OMR": 0.384957,
                    "PAB": 1,
                    "PEN": 3.801011,
                    "PGK": 3.9452,
                    "PHP": 56.33,
                    "PKR": 278.659095,
                    "PLN": 3.870068,
                    "PYG": 7732.226496,
                    "QAR": 3.644457,
                    "RON": 4.5038,
                    "RSD": 105.961,
                    "RUB": 90.553667,
                    "RWF": 1336,
                    "SAR": 3.753003,
                    "SBD": 8.348554,
                    "SCR": 13.505892,
                    "SDG": 601.5,
                    "SEK": 10.362785,
                    "SGD": 1.305305,
                    "SHP": 0.764307,
                    "SLL": 20969.5,
                    "SOS": 571.377153,
                    "SRD": 29.021,
                    "SSP": 130.26,
                    "STD": 22281.8,
                    "STN": 22.187808,
                    "SVC": 8.748257,
                    "SYP": 2512.53,
                    "SZL": 17.921978,
                    "THB": 33.854,
                    "TJS": 10.65304,
                    "TMT": 3.51,
                    "TND": 3.05,
                    "TOP": 2.34374,
                    "TRY": 34.050599,
                    "TTD": 6.793936,
                    "TWD": 32.094499,
                    "TZS": 2724.568,
                    "UAH": 41.13723,
                    "UGX": 3714.112445,
                    "USD": 1,
                    "UYU": 40.369388,
                    "UZS": 12700,
                    "VES": 36.650468,
                    "VND": 24615,
                    "VUV": 118.722,
                    "WST": 2.8,
                    "XAF": 593.972958,
                    "XAG": 0.03538445,
                    "XAU": 0.00039997,
                    "XCD": 2.70255,
                    "XDR": 0.741096,
                    "XOF": 593.972958,
                    "XPD": 0.00107205,
                    "XPF": 108.055601,
                    "XPT": 0.00106502,
                    "YER": 250.324978,
                    "ZAR": 17.86047,
                    "ZMW": 26.270603,
                    "ZWL": 322
                  }
                }
                """;


        currency = currency.toUpperCase(); // just incase :)
        String patternString = String.format("\"%s\": ([\\d.]+)", currency);

        Pattern pattern = Pattern.compile(patternString,Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(conversionData);
        if (matcher.find()) {
            var result = matcher.group(1);
            double conversionRate = Double.parseDouble(result);
            return conversionRate;
        } else {
            throw new RuntimeException("Invalid currency detected!");
        }
    }


}
