import java.util.Random;
import java.math.BigDecimal; // ������� ���������� N 2
import java.math.RoundingMode; // ������� ���������� N 2


public class WeatherProvider {
	
	private static double temperatureForToday = generateTemperature();
    private static double[] temperaturesFor10Days = generateTemperaturesForecastFor10Days();

    private static double generateTemperature() {
        Random rd = new Random(); 
        double temperature = 304 * (rd.nextDouble() - 0.5);// ��� ���������� � ������� ���������� N 2
        //double temperature = (double)((int) (304 * (rd.nextDouble() - 0.5) * 10)) / 10; // ������� ���������� N 1
        double roundTemperature = new BigDecimal(temperature).setScale(1, RoundingMode.UP).doubleValue(); // ������� ���������� N 2
        return roundTemperature; // ������� ���������� N 2
        //return temperature; // ��� ���������� � ������� ���������� N 1
    }

    private static double[] generateTemperaturesForecastFor10Days() {
        double [] forecastArray = new double [10];
        for(int i = 0; i < forecastArray.length; i++) {
        	forecastArray [i] = generateTemperature();
        }
        return forecastArray;
    }  

    public static double getTemperatureForTodayOriginal() {
    	return temperatureForToday;
    }
    
    public static double getTemperatureForTodayRounded() {
        if(temperatureForToday >= -150 && temperatureForToday <= 150) {
        	return temperatureForToday;
        }
        double temperatureForTodayRounded = 0;
        if(temperatureForToday < -150) {
        	temperatureForTodayRounded = -150;
        }
        else if(temperatureForToday > 150) {
           	temperatureForTodayRounded = 150;
        }
        return temperatureForTodayRounded;
    }
    
    public static double[] getTemperaturesForecastFor10DaysOriginal() {
    	return temperaturesFor10Days;
    }
    
    public static double[] getTemperaturesForecastFor10DaysRounded() {
    	for(int i = 0; i < temperaturesFor10Days.length; i++) {
        	if(temperaturesFor10Days [i] < -150 || temperaturesFor10Days [i] > 150){
        		break;
        	}
        	else if(i == temperaturesFor10Days.length - 1){
        		return temperaturesFor10Days;
        	}
        }
        double [] temperaturesFor10DaysRounded = new double [temperaturesFor10Days.length];
        for(int i = 0; i < temperaturesFor10DaysRounded.length; i++) {
        	if(temperaturesFor10Days [i] >= -150 && temperaturesFor10Days [i] <= 150){
        		temperaturesFor10DaysRounded[i] = temperaturesFor10Days[i];
        		continue;
        	}
        	else if(temperaturesFor10Days [i] < -150) {
        		temperaturesFor10DaysRounded[i] = -150;
        		continue;
        	}
        	else {
        		temperaturesFor10DaysRounded[i] = 150;
        	}
        }
        return temperaturesFor10DaysRounded;
    }
    
    public static double calculateAvgFor10DaysOriginal() {
        double avgTemp10Days = 0;
    	for(int i = 0; i < temperaturesFor10Days.length; i++) {
    		avgTemp10Days += temperaturesFor10Days[i];
    	}
    	return avgTemp10Days/temperaturesFor10Days.length;
    }
    
    public static double calculateAvgFor10DaysRounded () {
        double avgTemp10Days = 0;
    	for(int i = 0; i < getTemperaturesForecastFor10DaysRounded().length; i++) {
    		avgTemp10Days += getTemperaturesForecastFor10DaysRounded()[i];
    	}
    	return avgTemp10Days/getTemperaturesForecastFor10DaysRounded().length;
    }

    public static double getMaxTemperatureFor10DaysOriginal() {
    	double MaxTemp10Days = temperaturesFor10Days[0];
    	for(int i = 1; i < temperaturesFor10Days.length; i++) {
    		if(MaxTemp10Days >= temperaturesFor10Days[i]) {
    			continue;
    		}
    		MaxTemp10Days = temperaturesFor10Days[i];
    	}
    	return MaxTemp10Days;
    }
    
    public static double getMaxTemperatureFor10DaysRounded() {
    	double MaxTemp10Days = getTemperaturesForecastFor10DaysRounded()[0];
    	for(int i = 1; i < getTemperaturesForecastFor10DaysRounded().length; i++) {
    		if(MaxTemp10Days >= getTemperaturesForecastFor10DaysRounded()[i]) {
    			continue;
    		}
    		MaxTemp10Days = getTemperaturesForecastFor10DaysRounded()[i];
    	}
    	return MaxTemp10Days;
    }

    public static double getMinTemperatureFor10DaysOriginal() {
    	double MinTemp10Days = temperaturesFor10Days[0];
    	for(int i = 1; i < temperaturesFor10Days.length; i++) {
    		if(MinTemp10Days <= temperaturesFor10Days[i]) {
    			continue;
    		}
    		MinTemp10Days = temperaturesFor10Days[i];
    	}
    	return MinTemp10Days;
    }
    
    public static double getMinTemperatureFor10DaysRounded() {
    	double MinTemp10Days = getTemperaturesForecastFor10DaysRounded()[0];
    	for(int i = 1; i < getTemperaturesForecastFor10DaysRounded().length; i++) {
    		if(MinTemp10Days <= getTemperaturesForecastFor10DaysRounded()[i]) {
    			continue;
    		}
    		MinTemp10Days = getTemperaturesForecastFor10DaysRounded()[i];
    	}
    	return MinTemp10Days;
    }
}