package com.tdp.ms.angular.business.impl;

import com.tdp.ms.angular.business.AngularService;
import com.tdp.ms.angular.model.AngularResponse;
import org.springframework.stereotype.Service;

/**
 * Class: AngularServiceImpl. <br/>
 * <b>Copyright</b>: &copy; 2019 Telef&oacute;nica del Per&uacute;<br/>
 * <b>Company</b>: Telef&oacute;nica del Per&uacute;<br/>
 *
 * @author Telef&oacute;nica del Per&uacute; (TDP) <br/>
 *         <u>Service Provider</u>: Everis Per&uacute; SAC (EVE) <br/>
 *         <u>Developed by</u>: <br/>
 *         <ul>
 *         <li>Developer name</li>
 *         </ul>
 *         <u>Changes</u>:<br/>
 *         <ul>
 *         <li>YYYY-MM-DD Creaci&oacute;n del proyecto.</li>
 *         </ul>
 * @version 1.0
 */
@Service
public class AngularServiceImpl implements AngularService {

    @Override
    public AngularResponse get() {
        return new AngularResponse("Hello world!");
    }

    @Override
    public AngularResponse put(String name) {
        return new AngularResponse(name + " created!");
    }

}
