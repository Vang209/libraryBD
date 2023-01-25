package org.example.service;

import org.example.repository.LogRepository;
import org.example.view.LogView;

import java.time.LocalDate;

public class LogService {
    public void LogList(){
        for(int i = 0; i< LogRepository.logs.size(); i++){
            LogView.Sout(LogRepository.logs.get(i));
        }
    }

    public void LogTheDay(){

        LocalDate date = LocalDate.now();
        for(int i=0;i<LogRepository.logs.size();i++){
            if(date.equals(LogRepository.logs.get(i).getDate())){
                LogView.Sout(LogRepository.logs.get(i));
            }
        }
    }

    public void LogTheWeek(){
        LocalDate date = LocalDate.now();
        date.minusWeeks(1);

        for(int i=0;i<LogRepository.logs.size();i++){
            if(LogRepository.logs.get(i).getDate().isBefore(date)){
                LogView.Sout(LogRepository.logs.get(i));
            }
        }
    }

    public void LogTheMonth(){

        LocalDate date = LocalDate.now();
        date.minusMonths(1);

        for(int i=0;i<LogRepository.logs.size();i++){
            if(LogRepository.logs.get(i).getDate().isBefore(date)){
                LogView.Sout(LogRepository.logs.get(i));
            }
        }
    }

    public void LogTheYear(){
        LocalDate date = LocalDate.now();
        date.minusYears(1);

        for(int i=0;i<LogRepository.logs.size();i++){
            if(LogRepository.logs.get(i).getDate().isBefore(date)){
                LogView.Sout(LogRepository.logs.get(i));
            }
        }
    }
}
