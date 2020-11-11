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
package ca.bc.gov.ols.geocoder.data.indexing;

public class MisspellingOf<T> {
	private T item;
	private int error;
	private String misspelling;
	
	public MisspellingOf(T item, int error, String misspelling) {
		this.item = item;
		this.error = error;
		this.misspelling = misspelling;
	}
	
	public T get() {
		return item;
	}
	
	public int getError() {
		return error;
	}
	
	public String getMisspelling() {
		return misspelling;
	}
	
	@Override
	public String toString() {
		return item.toString() + "/" + error;
	}
}
