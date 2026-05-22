package io.github.chubbyhippo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

@RestController
public class ToggleController {
    private final FeatureManager featureManager;
    public static final Feature TOGGLE = new NamedFeature("TOGGLE");

    private final FirstService firstService;
    private final SecondService secondService;

    public ToggleController(FeatureManager featureManager, FirstService firstService, SecondService secondService) {
        this.featureManager = featureManager;
        this.firstService = firstService;
        this.secondService = secondService;
    }

    @GetMapping("/")
    public String getText() {
        if (featureManager.isActive(TOGGLE)) {
            return firstService.getText();
        }
        return secondService.getText();
    }

    @GetMapping("/toggle")
    public String toggle() {
        var state = featureManager.getFeatureState(TOGGLE);
        state.setEnabled(!state.isEnabled());
        featureManager.setFeatureState(state);
        return "Toggle state changed to " + state.isEnabled();
    }
}
