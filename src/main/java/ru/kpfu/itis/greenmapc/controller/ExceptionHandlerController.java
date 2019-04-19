package ru.kpfu.itis.greenmapc.controller;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.greenmapc.exception.NotFoundException;


@ControllerAdvice
public class ExceptionHandlerController {

    private final String MESSAGE = "Ресурс не найден";

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public ModelAndView handleError404(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error/404");
        modelAndView.addObject("message",
                e.getMessage() != null && !e.getMessage().isEmpty() ? e.getMessage() : MESSAGE );
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleError400(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error/400");
        modelAndView.addObject("message", MESSAGE);
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(PSQLException.class)
    public ModelAndView handlePSQLException(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error/404");
        modelAndView.addObject("message", "У нас проблемы!");
        return modelAndView;
    }
}
