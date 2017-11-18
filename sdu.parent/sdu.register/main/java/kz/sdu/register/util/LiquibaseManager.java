package kz.sdu.register.util;

public interface LiquibaseManager {
  void apply() throws Exception;
}
