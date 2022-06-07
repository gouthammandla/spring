package com.goutham.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;

@Controller
@EnableAspectJAutoProxy
@ComponentScan("com.goutham")
public class DemoConfig {
}
