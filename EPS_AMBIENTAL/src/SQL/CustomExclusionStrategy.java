package SQL;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class CustomExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        // Exclude fields with names that cause conflicts during serialization
        return f.getName().equals("connectionLifecycleInterceptors");
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}