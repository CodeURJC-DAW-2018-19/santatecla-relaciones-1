package es.santatecla.relaciones.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public String handlerError(MultipartException e, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/uploadStatus";

    }

}