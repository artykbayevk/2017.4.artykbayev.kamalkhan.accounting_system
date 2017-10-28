package kz.sdu.stand.util;

import java.io.File;
import java.io.IOException;

public class Modules {

    private static File findDir(String moduleName) {
        {
            File point = new File(".");
            if (point.getAbsoluteFile().getName().equals(moduleName)) {
                return point;
            }
        }

        {
            File dir = new File(moduleName);
            try {
                if (dir.isDirectory() &&
                        dir.toPath().resolve("..").toFile().getCanonicalFile().getName().equals("sdu.parent")) {
                    return dir;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        {
            File dir = new File("../" + moduleName);
            if (dir.isDirectory()) return dir;
        }

        throw new IllegalArgumentException("Cannot find directory " + moduleName);
    }

    public static File clientDir() {
        return findDir("sdu.client");
    }

    public static File standDir() {
        return findDir("sdu.stand");
    }

    public static File controllerDir() {
        return findDir("sdu.controller");
    }
}