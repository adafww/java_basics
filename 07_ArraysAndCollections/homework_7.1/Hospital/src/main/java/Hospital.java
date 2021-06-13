public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] patientTemperate = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++){

            patientTemperate[i] = (float) (Math.random() * 8 + 32) * 100 / 100;
        }

        return patientTemperate;
    }

    public static String getReport(float[] temperatureData) {

        String temperature = "";
        float middleTemperature = 0;
        int countOfHealthy = 0;

        for (int i = 0; i < temperatureData.length; i++){

            if (i == temperatureData.length - 1){

                temperature += temperatureData[i];
            }else {

                temperature += temperatureData[i] + " ";
            }
            middleTemperature += temperatureData[i];
            if (temperatureData[i] < 37 && temperatureData[i] > 36.1){

                countOfHealthy++;
            }
        }

        String report =
                "Температуры пациентов: " + temperature +
                        "\nСредняя температура: " + Math.round(middleTemperature / temperatureData.length * 100) / 100D +
                        "\nКоличество здоровых: " + countOfHealthy;

        return report;
    }
}
