package com.multi.sample.persistence.config;

import com.multi.sample.persistence.constants.SchemaConstants;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomPhysicalNameStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        Identifier tableName = new Identifier(SchemaConstants.TABLE_PRE_FIX + this.convertToUnderscore(name), name.isQuoted());
        return super.toPhysicalTableName(tableName, context);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return super.toPhysicalColumnName(this.convertToUnderscore(name), context);
    }

    private Identifier convertToUnderscore(Identifier identifier) {
        String regex = "([a-z])([A-Z])";
        String replacement = "$1_$2";
        String newName = identifier.getText().replaceAll(regex, replacement).toLowerCase();

        return Identifier.toIdentifier(newName);
    }
}
