package com.goganesh.gallery.application.configuration;

import com.goganesh.gallery.datatablespagination.configuration.DataTablesPaginationConfiguration;
import com.goganesh.gallery.migration.configuration.MigrationConfiguration;
import com.goganesh.gallery.security.configuration.SecurityConfiguration;
import com.goganesh.gallery.webapi.configuration.WebApiConfiguration;
import com.goganesh.gallery.webui.configuration.WebUiConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({WebUiConfiguration.class, WebApiConfiguration.class, SecurityConfiguration.class, DataTablesPaginationConfiguration.class, MigrationConfiguration.class})
public class ApplicationConfiguration {
}
