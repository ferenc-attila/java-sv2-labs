package resourcebundle;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ResourceBundleTest {

    @Test
    public void testGetMessage() {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("hu", "HU"));
        String message = bundle.getString("label.save");
        assertThat(message, equalTo("Mentés"));

        ResourceBundle enBundle = ResourceBundle.getBundle("messages", Locale.UK);
        String enMessage = enBundle.getString("label.save");
        assertThat(enMessage, equalTo("Save"));
    }
}
