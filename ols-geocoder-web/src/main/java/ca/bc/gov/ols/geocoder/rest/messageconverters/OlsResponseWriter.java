/**
 * Copyright © 2008-2019, Province of British Columbia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ca.bc.gov.ols.geocoder.rest.messageconverters;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.locationtech.jts.geom.Point;

import ca.bc.gov.ols.geocoder.config.GeocoderConfig;

public interface OlsResponseWriter {

	void documentHeader() throws IOException;

	void empty() throws IOException;

	void field(String fieldName, Object fieldValue) throws IOException;
	
	void field(String fieldName, Object fieldValue, boolean forceString) throws IOException;

	void field(String glossaryName, String fieldName, Object fieldValue) throws IOException;

	void field(String glossaryName, String fieldName, Object fieldValue,
			boolean forceString) throws IOException;

	void searchResultsHeader() throws IOException;

	void fieldListHeader() throws IOException;

	void fieldListFooter() throws IOException;

	void matchesHeader() throws IOException;

	void matchesFooter() throws IOException;

	void searchResultsFooter() throws IOException;

	void featureCollectionHeader() throws IOException;

	void featureCollectionFooter() throws IOException;

	void documentFooter() throws IOException;

	void unknown(Object responseObj) throws IOException;

	void noMatches() throws IOException;

	void featureHeader(Point loc) throws IOException;

	void featureFooter() throws IOException;

	void faultsHeader() throws IOException;

	void faultsFooter() throws IOException;

	void faultHeader() throws IOException;

	void faultFooter() throws IOException;

	static Object formatDate(Object field) {
		if(field instanceof LocalDate) {
			return ((LocalDate)field).format(GeocoderConfig.DATE_FORMATTER);
		} else if(field instanceof LocalDateTime) {
			return ((LocalDateTime)field).format(GeocoderConfig.DATE_TIME_FORMATTER);
		}
		return field;
	}
}
