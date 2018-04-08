(ns fit-sdk.listener
  (:require [clojure.tools.logging :as log])
  (:import (com.garmin.fit FileIdMesgListener FileIdMesg
                           UserProfileMesgListener UserProfileMesg
                           DeviceInfoMesgListener DeviceInfoMesg
                           MonitoringMesgListener MonitoringMesg
                           RecordMesgListener RecordMesg
                           DeveloperFieldDescriptionListener DeveloperFieldDescription
                           File)))

(defn file-id-handler
  "Handles File Id messages"
  [mesg]
  (log/info "File Id:")
  (when (.getType mesg)
    (log/info (str "    Type: " (-> (.getType mesg) (.getValue))))))

(defn user-profile-handler
  "Handles User profile messages"
  [mesg]
  (log/info "User profile Message"))

(defn device-info-handler
  "Handles device info messages"
  [mesg]
  (log/info "Device info message"))

(defn monitor-handler
  "Handles monitor messages"
  [mesg]
  (log/info "Monitor message"))

(defn record-handler
  "Handles record messages"
  [mesg]
  (log/info "Record message"))

(defn developer-field-description
  "Handles developer field description"
  [desc]
  (log/info "Developer field description"))

(def broadcast-listener (reify
         FileIdMesgListener (^void onMesg [this ^FileIdMesg mesg] (file-id-handler mesg))
         UserProfileMesgListener (^void onMesg [this ^UserProfileMesg mesg] (user-profile-handler mesg))
         DeviceInfoMesgListener (^void onMesg [this ^DeviceInfoMesg mesg] (device-info-handler mesg))
         MonitoringMesgListener (^void onMesg [this ^MonitoringMesg mesg] (monitor-handler mesg))
         RecordMesgListener (^void onMesg [this ^RecordMesg mesg] (record-handler mesg))
         DeveloperFieldDescriptionListener (^void onDescription [this ^DeveloperFieldDescription desc] (device-info-handler desc))))

