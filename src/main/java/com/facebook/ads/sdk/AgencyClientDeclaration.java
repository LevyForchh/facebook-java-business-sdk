/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class AgencyClientDeclaration extends APINode {
  @SerializedName("agency_representing_client")
  private Long mAgencyRepresentingClient = null;
  @SerializedName("client_based_in_france")
  private Long mClientBasedInFrance = null;
  @SerializedName("has_written_mandate_from_advertiser")
  private Long mHasWrittenMandateFromAdvertiser = null;
  @SerializedName("is_client_paying_invoices")
  private Long mIsClientPayingInvoices = null;
  @SerializedName("client_name")
  private String mClientName = null;
  @SerializedName("client_email_address")
  private String mClientEmailAddress = null;
  @SerializedName("client_street")
  private String mClientStreet = null;
  @SerializedName("client_street2")
  private String mClientStreet2 = null;
  @SerializedName("client_city")
  private String mClientCity = null;
  @SerializedName("client_province")
  private String mClientProvince = null;
  @SerializedName("client_postal_code")
  private String mClientPostalCode = null;
  @SerializedName("client_country_code")
  private String mClientCountryCode = null;
  protected static Gson gson = null;

  public AgencyClientDeclaration() {
  }

  public String getId() {
    return null;
  }
  public static AgencyClientDeclaration loadJSON(String json, APIContext context) {
    AgencyClientDeclaration agencyClientDeclaration = getGson().fromJson(json, AgencyClientDeclaration.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(agencyClientDeclaration.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if(!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    agencyClientDeclaration.mContext = context;
    agencyClientDeclaration.rawValue = json;
    return agencyClientDeclaration;
  }

  public static APINodeList<AgencyClientDeclaration> parseResponse(String json, APIContext context, APIRequest request) {
    APINodeList<AgencyClientDeclaration> agencyClientDeclarations = new APINodeList<AgencyClientDeclaration>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          agencyClientDeclarations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return agencyClientDeclarations;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          try {
            JsonObject paging = obj.get("paging").getAsJsonObject().get("cursors").getAsJsonObject();
            agencyClientDeclarations.setPaging(paging.get("before").getAsString(), paging.get("after").getAsString());
          } catch (Exception ignored) {
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              agencyClientDeclarations.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            agencyClientDeclarations.add(loadJSON(obj.toString(), context));
          }
          return agencyClientDeclarations;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              agencyClientDeclarations.add(loadJSON(entry.getValue().toString(), context));
          }
          return agencyClientDeclarations;
        } else {
          // Fifth, check if it's pure JsonObject
          agencyClientDeclarations.add(loadJSON(json, context));
          return agencyClientDeclarations;
        }
      }
    } catch (Exception e) {
    }
    return null;
  }

  @Override
  public APIContext getContext() {
    return mContext;
  }

  @Override
  public void setContext(APIContext context) {
    mContext = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public Long getFieldAgencyRepresentingClient() {
    return mAgencyRepresentingClient;
  }

  public AgencyClientDeclaration setFieldAgencyRepresentingClient(Long value) {
    this.mAgencyRepresentingClient = value;
    return this;
  }

  public Long getFieldClientBasedInFrance() {
    return mClientBasedInFrance;
  }

  public AgencyClientDeclaration setFieldClientBasedInFrance(Long value) {
    this.mClientBasedInFrance = value;
    return this;
  }

  public Long getFieldHasWrittenMandateFromAdvertiser() {
    return mHasWrittenMandateFromAdvertiser;
  }

  public AgencyClientDeclaration setFieldHasWrittenMandateFromAdvertiser(Long value) {
    this.mHasWrittenMandateFromAdvertiser = value;
    return this;
  }

  public Long getFieldIsClientPayingInvoices() {
    return mIsClientPayingInvoices;
  }

  public AgencyClientDeclaration setFieldIsClientPayingInvoices(Long value) {
    this.mIsClientPayingInvoices = value;
    return this;
  }

  public String getFieldClientName() {
    return mClientName;
  }

  public AgencyClientDeclaration setFieldClientName(String value) {
    this.mClientName = value;
    return this;
  }

  public String getFieldClientEmailAddress() {
    return mClientEmailAddress;
  }

  public AgencyClientDeclaration setFieldClientEmailAddress(String value) {
    this.mClientEmailAddress = value;
    return this;
  }

  public String getFieldClientStreet() {
    return mClientStreet;
  }

  public AgencyClientDeclaration setFieldClientStreet(String value) {
    this.mClientStreet = value;
    return this;
  }

  public String getFieldClientStreet2() {
    return mClientStreet2;
  }

  public AgencyClientDeclaration setFieldClientStreet2(String value) {
    this.mClientStreet2 = value;
    return this;
  }

  public String getFieldClientCity() {
    return mClientCity;
  }

  public AgencyClientDeclaration setFieldClientCity(String value) {
    this.mClientCity = value;
    return this;
  }

  public String getFieldClientProvince() {
    return mClientProvince;
  }

  public AgencyClientDeclaration setFieldClientProvince(String value) {
    this.mClientProvince = value;
    return this;
  }

  public String getFieldClientPostalCode() {
    return mClientPostalCode;
  }

  public AgencyClientDeclaration setFieldClientPostalCode(String value) {
    this.mClientPostalCode = value;
    return this;
  }

  public String getFieldClientCountryCode() {
    return mClientCountryCode;
  }

  public AgencyClientDeclaration setFieldClientCountryCode(String value) {
    this.mClientCountryCode = value;
    return this;
  }




  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public AgencyClientDeclaration copyFrom(AgencyClientDeclaration instance) {
    this.mAgencyRepresentingClient = instance.mAgencyRepresentingClient;
    this.mClientBasedInFrance = instance.mClientBasedInFrance;
    this.mHasWrittenMandateFromAdvertiser = instance.mHasWrittenMandateFromAdvertiser;
    this.mIsClientPayingInvoices = instance.mIsClientPayingInvoices;
    this.mClientName = instance.mClientName;
    this.mClientEmailAddress = instance.mClientEmailAddress;
    this.mClientStreet = instance.mClientStreet;
    this.mClientStreet2 = instance.mClientStreet2;
    this.mClientCity = instance.mClientCity;
    this.mClientProvince = instance.mClientProvince;
    this.mClientPostalCode = instance.mClientPostalCode;
    this.mClientCountryCode = instance.mClientCountryCode;
    this.mContext = instance.mContext;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AgencyClientDeclaration> getParser() {
    return new APIRequest.ResponseParser<AgencyClientDeclaration>() {
      public APINodeList<AgencyClientDeclaration> parseResponse(String response, APIContext context, APIRequest<AgencyClientDeclaration> request) {
        return AgencyClientDeclaration.parseResponse(response, context, request);
      }
    };
  }
}